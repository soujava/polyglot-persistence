/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana (@otaviojava)
 * Carlos Santos (@carlosepdsJava)
 */

package org.jnosql.polyglot.column;


import jakarta.nosql.column.ColumnDeleteQuery;
import jakarta.nosql.mapping.column.ColumnTemplate;
import org.jnosql.polyglot.God;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Optional;
import static jakarta.nosql.column.ColumnDeleteQuery.delete;

public class ColumnRepositoryApp {
    public static void main(String[] args)  {

        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {

            God diana = new God(1L, "Diana", "Hunt");

            ColumnTemplate template =
                    container.select(ColumnTemplate.class)
                            .get();
            template.insert(diana);

            final Optional<God> god = template.find(God.class, 1L);
            System.out.println("query : " + god);

            ColumnDeleteQuery deleteQuery = delete().from("God")
                    .where("_id").eq(1L).build();

            template.delete(deleteQuery);

            System.out.println("query again: " +
                    template.find(God.class, 1L));
        }
        System.exit(0);
    }
}
