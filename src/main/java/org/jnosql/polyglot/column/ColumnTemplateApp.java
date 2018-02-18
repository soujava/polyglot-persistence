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
 * Otavio Santana
 */
package org.jnosql.polyglot.column;

import org.jnosql.artemis.column.ColumnTemplate;
import org.jnosql.diana.api.column.ColumnQuery;
import org.jnosql.polyglot.God;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Duration;
import java.util.List;

import static org.jnosql.diana.api.column.query.ColumnQueryBuilder.select;
import static org.jnosql.polyglot.God.builder;

public class ColumnTemplateApp {
    public static void main(String[] args) throws InterruptedException {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ColumnTemplate template = container.select(ColumnTemplate.class).get();
            God diana = builder().withId("diana").withName("Diana").withPower("hunt").builder();
            template.insert(diana);

            ColumnQuery query = select().from("god").where("_id").eq("diana").build();

            List<God> result = template.select(query);
            result.forEach(System.out::println);

            template.insert(diana, Duration.ofSeconds(1));
            Thread.sleep(2_000L);
            System.out.println(template.select(query));

        }
    }
}
