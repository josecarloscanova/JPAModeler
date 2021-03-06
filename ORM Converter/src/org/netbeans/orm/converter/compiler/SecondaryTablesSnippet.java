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
package org.netbeans.orm.converter.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.netbeans.orm.converter.util.ORMConverterUtil;

public class SecondaryTablesSnippet implements Snippet {

    private List<SecondaryTableSnippet> secondaryTables = Collections.EMPTY_LIST;

    public void addSecondaryTable(SecondaryTableSnippet secondaryTable) {
        if (secondaryTables.isEmpty()) {
            secondaryTables = new ArrayList<SecondaryTableSnippet>();
        }

        secondaryTables.add(secondaryTable);
    }

    public List<SecondaryTableSnippet> getSecondaryTables() {
        return secondaryTables;
    }

    public void setSecondaryTables(List<SecondaryTableSnippet> secondaryTables) {
        if (secondaryTables != null) {
            this.secondaryTables = secondaryTables;
        }
    }

    @Override
    public String getSnippet() throws InvalidDataException {

        if (secondaryTables.isEmpty()) {
            throw new InvalidDataException("Missing SecondaryTables");
        }

        if (secondaryTables.size() == 1) {
            return secondaryTables.get(0).getSnippet();
        }

        StringBuilder builder = new StringBuilder();

        builder.append("@SecondaryTables({");

        for (SecondaryTableSnippet secondaryTable : secondaryTables) {
            builder.append(secondaryTable.getSnippet());
            builder.append(ORMConverterUtil.COMMA);
        }

        return builder.substring(0, builder.length() - 1)
                + ORMConverterUtil.CLOSE_BRACES
                + ORMConverterUtil.CLOSE_PARANTHESES;
    }

    @Override
    public Collection<String> getImportSnippets() throws InvalidDataException {

        if (secondaryTables.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        if (secondaryTables.size() == 1) {
            return secondaryTables.get(0).getImportSnippets();
        }

        Collection<String> importSnippets = new ArrayList<>();

        importSnippets.add("javax.persistence.SecondaryTables");

        for (SecondaryTableSnippet secondaryTable : secondaryTables) {
            importSnippets.addAll(secondaryTable.getImportSnippets());
        }

        return importSnippets;
    }
}
