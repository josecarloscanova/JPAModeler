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
package org.netbeans.jpa.modeler.properties.joincolumn;

import javax.swing.JOptionPane;
import org.netbeans.jpa.modeler.spec.JoinColumn;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.Entity;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.RowValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.internal.EntityComponent;

public class JoinColumnPanel extends EntityComponent<JoinColumn> {

    private final org.netbeans.jpa.modeler.spec.Entity entity;

    public JoinColumnPanel(org.netbeans.jpa.modeler.spec.Entity entity) {
        this.entity = entity;
    }

    @Override
    public void postConstruct() {
        initComponents();
    }

    @Override
    public void init() {
    }

    @Override
    public void createEntity(Class<? extends Entity> entityWrapperType) {
        this.setTitle("Create new JoinColumn");
        if (entityWrapperType == RowValue.class) {
            this.setEntity(new RowValue(new Object[4]));
        }
        name_TextField.setText("");
        table_TextField.setText("");
        columnDefinition_TextArea.setText("");
        unique_CheckBox.setSelected(false);
        nullable_CheckBox.setSelected(true);
        insertable_CheckBox.setSelected(true);
        updatable_CheckBox.setSelected(true);
//        JPAModelerUtil.initReferencedColumnModel(referencedColumnName_ComboBox, entity, null);

    }

    @Override
    public void updateEntity(Entity<JoinColumn> entityValue) {
        this.setTitle("Update JoinColumn");
        if (entityValue.getClass() == RowValue.class) {
            this.setEntity(entityValue);
            Object[] row = ((RowValue) entityValue).getRow();
            JoinColumn joinColumn = (JoinColumn) row[0];
            name_TextField.setText(joinColumn.getName());
//            JPAModelerUtil.initReferencedColumnModel(referencedColumnName_ComboBox, entity, joinColumn.getReferencedColumn());
            referencedColumnName_TextField.setText(joinColumn.getReferencedColumnName());
            table_TextField.setText(joinColumn.getTable());
            columnDefinition_TextArea.setText(joinColumn.getColumnDefinition());
            unique_CheckBox.setSelected(joinColumn.getUnique());
            nullable_CheckBox.setSelected(joinColumn.getNullable());
            insertable_CheckBox.setSelected(joinColumn.getInsertable());
            updatable_CheckBox.setSelected(joinColumn.getUpdatable());

        }
    }
//    
//        public static void initReferencedColumnModel(javax.swing.JComboBox columnComboBox, org.netbeans.jpa.modeler.spec.Entity entity, Id selectedColumn) {
//        columnComboBox.setEditable(true);
//        columnComboBox.removeAllItems();
//        columnComboBox.addItem(new ComboBoxValue(null, ""));
//        if (entity != null) {
////            entity.getAttributes().getBasic().stream().forEach((basic) -> {
////                if (basic.getColumn() != null && org.apache.commons.lang.StringUtils.isNotBlank(basic.getColumn().getName())) {
////                    columnComboBox.addItem(new ComboBoxValue(basic, basic.getColumn().getName()));
////                } else {
////                    columnComboBox.addItem(new ComboBoxValue(basic, basic.getName()));
////                }
////            });
//            int i = 0;
//            int selectedItemIndex = -1;
//            for (Id id : entity.getAttributes().getId()) {
//                String columnName = id.getReferenceColumnName();
//                columnComboBox.addItem(new ComboBoxValue(id, columnName));
//                if (id == selectedColumn) {
//                    selectedItemIndex = ++i;
//                }
//            }
//            columnComboBox.setSelectedIndex(selectedItemIndex);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        name_LayeredPane = new javax.swing.JLayeredPane();
        name_Label = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        table_LayeredPane = new javax.swing.JLayeredPane();
        table_Label = new javax.swing.JLabel();
        table_TextField = new javax.swing.JTextField();
        referencedColumnName_LayeredPane = new javax.swing.JLayeredPane();
        referencedColumnName_Label = new javax.swing.JLabel();
        referencedColumnName_TextField = new javax.swing.JTextField();
        columnDefinition_LayeredPane = new javax.swing.JLayeredPane();
        columnDefinition_Label = new javax.swing.JLabel();
        columnDefinition_ScrollPane = new javax.swing.JScrollPane();
        columnDefinition_TextArea = new javax.swing.JTextArea();
        layeredPane = new javax.swing.JLayeredPane();
        nullable_CheckBox = new javax.swing.JCheckBox();
        updatable_CheckBox = new javax.swing.JCheckBox();
        insertable_CheckBox = new javax.swing.JCheckBox();
        unique_CheckBox = new javax.swing.JCheckBox();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        save_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        name_LayeredPane.setToolTipText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.name_LayeredPane.toolTipText")); // NOI18N
        name_LayeredPane.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(name_Label, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.name_Label.text")); // NOI18N
        name_LayeredPane.add(name_Label, java.awt.BorderLayout.WEST);

        name_TextField.setText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.name_TextField.text")); // NOI18N
        name_TextField.setToolTipText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.name_TextField.toolTipText")); // NOI18N
        name_LayeredPane.add(name_TextField, java.awt.BorderLayout.CENTER);

        table_LayeredPane.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(table_Label, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.table_Label.text")); // NOI18N
        table_LayeredPane.add(table_Label, java.awt.BorderLayout.WEST);

        table_TextField.setText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.table_TextField.text")); // NOI18N
        table_LayeredPane.add(table_TextField, java.awt.BorderLayout.CENTER);

        referencedColumnName_LayeredPane.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(referencedColumnName_Label, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.referencedColumnName_Label.text")); // NOI18N
        referencedColumnName_LayeredPane.add(referencedColumnName_Label, java.awt.BorderLayout.WEST);

        referencedColumnName_TextField.setText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.referencedColumnName_TextField.text")); // NOI18N
        referencedColumnName_LayeredPane.add(referencedColumnName_TextField, java.awt.BorderLayout.CENTER);

        columnDefinition_LayeredPane.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(columnDefinition_Label, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.columnDefinition_Label.text")); // NOI18N
        columnDefinition_LayeredPane.add(columnDefinition_Label, java.awt.BorderLayout.WEST);

        columnDefinition_TextArea.setColumns(20);
        columnDefinition_TextArea.setRows(5);
        columnDefinition_ScrollPane.setViewportView(columnDefinition_TextArea);

        columnDefinition_LayeredPane.add(columnDefinition_ScrollPane, java.awt.BorderLayout.CENTER);

        layeredPane.setLayout(new java.awt.GridLayout(1, 4));

        org.openide.awt.Mnemonics.setLocalizedText(nullable_CheckBox, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.nullable_CheckBox.text")); // NOI18N
        layeredPane.add(nullable_CheckBox);

        org.openide.awt.Mnemonics.setLocalizedText(updatable_CheckBox, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.updatable_CheckBox.text")); // NOI18N
        layeredPane.add(updatable_CheckBox);

        org.openide.awt.Mnemonics.setLocalizedText(insertable_CheckBox, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.insertable_CheckBox.text")); // NOI18N
        layeredPane.add(insertable_CheckBox);

        org.openide.awt.Mnemonics.setLocalizedText(unique_CheckBox, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.unique_CheckBox.text")); // NOI18N
        layeredPane.add(unique_CheckBox);

        org.openide.awt.Mnemonics.setLocalizedText(save_Button, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.save_Button.text")); // NOI18N
        save_Button.setToolTipText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.save_Button.toolTipText")); // NOI18N
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });
        jLayeredPane8.add(save_Button);
        save_Button.setBounds(20, 0, 70, 29);

        org.openide.awt.Mnemonics.setLocalizedText(cancel_Button, org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.cancel_Button.text")); // NOI18N
        cancel_Button.setToolTipText(org.openide.util.NbBundle.getMessage(JoinColumnPanel.class, "JoinColumnPanel.cancel_Button.toolTipText")); // NOI18N
        cancel_Button.setPreferredSize(new java.awt.Dimension(60, 23));
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });
        jLayeredPane8.add(cancel_Button);
        cancel_Button.setBounds(100, 0, 70, 30);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table_LayeredPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(name_LayeredPane)
                    .addComponent(referencedColumnName_LayeredPane)
                    .addComponent(columnDefinition_LayeredPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 137, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(layeredPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referencedColumnName_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnDefinition_LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layeredPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1.setLayer(name_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(table_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(referencedColumnName_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(columnDefinition_LayeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(layeredPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private boolean validateField() {
        if (this.name_TextField.getText().trim().length() <= 0 /*|| Pattern.compile("[^\\w-]").matcher(this.id_TextField.getText().trim()).find()*/) {
            JOptionPane.showMessageDialog(this, "Parameter column name can't be empty", "Invalid Value", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }//I18n
//        if (this.referencedColumnName_TextField.getText().trim().length() <= 0 /*|| Pattern.compile("[^\\w-]").matcher(this.id_TextField.getText().trim()).find()*/) {
//            JOptionPane.showMessageDialog(this, "Parameter referenced column name can't be empty", "Invalid Value", javax.swing.JOptionPane.WARNING_MESSAGE);
//            return false;
//        }//I18n
        return true;
    }

    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        if (!validateField()) {
            return;
        }
        JoinColumn joinColumn = null;

        if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            if (row[0] == null) {
                joinColumn = new JoinColumn();
            } else {
                joinColumn = (JoinColumn) row[0];
            }
        }

        joinColumn.setName(name_TextField.getText());
        joinColumn.setReferencedColumnName(referencedColumnName_TextField.getText());
//        Object selectedItem = referencedColumnName_ComboBox.getSelectedItem();
//        if (selectedItem != null && selectedItem instanceof ComboBoxValue) {
//            joinColumn.setReferencedColumn((Id) ((ComboBoxValue) selectedItem).getValue());
////        } else if (selectedItem != null) {
////            joinColumn.setReferencedColumnName(selectedItem.toString());
//        } else {
//            joinColumn.setReferencedColumn(null);
//        }
        joinColumn.setTable(table_TextField.getText());
        joinColumn.setColumnDefinition(columnDefinition_TextArea.getText());
        joinColumn.setUnique(unique_CheckBox.isSelected());
        joinColumn.setNullable(nullable_CheckBox.isSelected());
        joinColumn.setInsertable(insertable_CheckBox.isSelected());
        joinColumn.setUpdatable(updatable_CheckBox.isSelected());

        if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            row[0] = joinColumn;
            row[1] = joinColumn.getName();
            row[2] = joinColumn.getReferencedColumnName();//for representation
        }

        saveActionPerformed(evt);
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        cancelActionPerformed(evt);
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_Button;
    private javax.swing.JLabel columnDefinition_Label;
    private javax.swing.JLayeredPane columnDefinition_LayeredPane;
    private javax.swing.JScrollPane columnDefinition_ScrollPane;
    private javax.swing.JTextArea columnDefinition_TextArea;
    private javax.swing.JCheckBox insertable_CheckBox;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JLabel name_Label;
    private javax.swing.JLayeredPane name_LayeredPane;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JCheckBox nullable_CheckBox;
    private javax.swing.JLabel referencedColumnName_Label;
    private javax.swing.JLayeredPane referencedColumnName_LayeredPane;
    private javax.swing.JTextField referencedColumnName_TextField;
    private javax.swing.JButton save_Button;
    private javax.swing.JLabel table_Label;
    private javax.swing.JLayeredPane table_LayeredPane;
    private javax.swing.JTextField table_TextField;
    private javax.swing.JCheckBox unique_CheckBox;
    private javax.swing.JCheckBox updatable_CheckBox;
    // End of variables declaration//GEN-END:variables
}
