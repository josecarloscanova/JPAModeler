/**
 * Copyright [2016] Gaurav Gupta
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
package org.netbeans.jpa.modeler.spec.extend;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Gaurav Gupta
 */
public abstract class QueryMapping extends DataMapping {
    
    @XmlElement(required = true)
    protected String query;

    public boolean refactorQuery(String prevQuery, String newQuery) {
        if (this.getQuery().contains(prevQuery)) {
            this.setQuery(this.getQuery().replaceAll(prevQuery, newQuery));
            return true;
        } else {
            return false;
        }
    }
    
    

    /**
     * Gets the value of the query property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setQuery(String value) {
        this.query = value;
    }
}
