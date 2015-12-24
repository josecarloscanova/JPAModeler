/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jpa.modeler.navigator.entitygraph;

import java.util.List;
import org.netbeans.jpa.modeler.core.widget.EmbeddableWidget;
import org.netbeans.jpa.modeler.core.widget.EntityWidget;
import org.netbeans.jpa.modeler.core.widget.PersistenceClassWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.AttributeWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.base.EmbeddedAttributeWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.base.EmbeddedIdAttributeWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.base.IdAttributeWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.base.TransientAttributeWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.base.VersionAttributeWidget;
import org.netbeans.jpa.modeler.core.widget.attribute.relation.RelationAttributeWidget;
import org.netbeans.jpa.modeler.navigator.entitygraph.component.spec.EGChildNode;
import org.netbeans.jpa.modeler.navigator.entitygraph.component.EGLeafNode;
import org.netbeans.jpa.modeler.navigator.entitygraph.component.EGInternalNode;
import org.netbeans.jpa.modeler.navigator.entitygraph.component.EGRootNode;
import org.netbeans.jpa.modeler.spec.NamedAttributeNode;
import org.netbeans.jpa.modeler.spec.NamedSubgraph;
import org.netbeans.jpa.modeler.spec.extend.Attribute;
import org.netbeans.modeler.specification.model.document.widget.IFlowElementWidget;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class NamedEGChildFactory extends EGChildFactory {

    @Override
    protected boolean createKeys(List<AttributeWidget> attributeWidgets) {
        PersistenceClassWidget classWidget = null;
        if (parentNode instanceof EGRootNode) {
            classWidget = ((EGRootNode) parentNode).getRootWidget();
        } else if (parentNode instanceof EGInternalNode) {
            classWidget = ((EGInternalNode) parentNode).getParentWidget();
        }
        if (classWidget != null) {
            for (AttributeWidget attributeWidget : classWidget.getAllAttributeWidgets()) {
                if (attributeWidget instanceof TransientAttributeWidget || (attributeWidget instanceof RelationAttributeWidget && !((RelationAttributeWidget) attributeWidget).isOwner())) {
                    // skip
                } else {//check for all remaining
                    attributeWidgets.add(attributeWidget);
                }
            }
        }

        return true;
    }

    @Override
    protected Node createNodeForKey(final AttributeWidget attributeWidget) {
        EGChildNode childNode;
        CheckableAttributeNode checkableNode = new CheckableAttributeNode();
        NamedSubgraph subgraph = null;

        boolean isPK = attributeWidget instanceof IdAttributeWidget || attributeWidget instanceof EmbeddedIdAttributeWidget || attributeWidget instanceof VersionAttributeWidget;

        if (parentNode.getNamedEntityGraph() != null && !isPK) {
            Attribute attribute = (Attribute) attributeWidget.getBaseElementSpec();
            NamedAttributeNode namedAttributeNode = null;
            if (parentNode instanceof EGRootNode) {
                namedAttributeNode = parentNode.getNamedEntityGraph().findNamedAttributeNode(attribute.getName());
            } else if (parentNode instanceof EGInternalNode && ((EGInternalNode) parentNode).getSubgraph() != null) {
                namedAttributeNode = ((EGInternalNode) parentNode).getSubgraph().findNamedAttributeNode(attribute.getName());
            }

            if (namedAttributeNode != null) {
                checkableNode.setSelected(Boolean.TRUE);
                if (namedAttributeNode.getSubgraph() != null && !namedAttributeNode.getSubgraph().isEmpty()) {
                    subgraph = parentNode.getNamedEntityGraph().findSubgraph(namedAttributeNode.getSubgraph());
                }
            }
        }

        if (attributeWidget instanceof EmbeddedAttributeWidget) {
            EmbeddedAttributeWidget embeddedAttributeWidget = (EmbeddedAttributeWidget) attributeWidget;
            EmbeddableWidget embeddableWidget = embeddedAttributeWidget.getEmbeddableFlowWidget().getTargetEmbeddableWidget();

            NamedEGChildFactory childFactory = new NamedEGChildFactory();//parentWidget, embeddedAttributeWidget, embeddableWidget );
            childNode = new EGInternalNode(embeddableWidget, embeddedAttributeWidget, parentNode.getNamedEntityGraph(), subgraph, childFactory, checkableNode);
        } else if (attributeWidget instanceof RelationAttributeWidget) {
            RelationAttributeWidget relationAttributeWidget = (RelationAttributeWidget) attributeWidget;
            IFlowElementWidget targetElementWidget = relationAttributeWidget.getRelationFlowWidget().getTargetWidget();
            EntityWidget targetEntityWidget = null;
            if (targetElementWidget instanceof EntityWidget) {
                targetEntityWidget = (EntityWidget) targetElementWidget;
            } else if (targetElementWidget instanceof RelationAttributeWidget) {
                RelationAttributeWidget targetRelationAttributeWidget = (RelationAttributeWidget) targetElementWidget;
                targetEntityWidget = (EntityWidget) targetRelationAttributeWidget.getClassWidget();//target can be only Entity
            }

            NamedEGChildFactory childFactory = new NamedEGChildFactory();//parentWidget, relationAttributeWidget, targetEntityWidget);
            childNode = new EGInternalNode(targetEntityWidget, relationAttributeWidget, parentNode.getNamedEntityGraph(), subgraph, childFactory, checkableNode);
        } else {
            childNode = new EGLeafNode(attributeWidget, parentNode.getNamedEntityGraph(), Children.LEAF, checkableNode);
        }
        childNode.setParent(parentNode);
        parentNode.addChild(childNode);

        if (isPK) {
            checkableNode.setCheckEnabled(Boolean.FALSE);
            checkableNode.setEnableWithParent(Boolean.TRUE);
        }

        return (Node) childNode;
    }

}