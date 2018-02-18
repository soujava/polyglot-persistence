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
package org.jnosql.polyglot.document;

import org.jnosql.artemis.document.DocumentTemplate;
import org.jnosql.diana.api.document.DocumentQuery;
import org.jnosql.polyglot.God;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Duration;
import java.util.List;

import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.select;
import static org.jnosql.polyglot.God.builder;

public class DocumentTemplateApp {
    public static void main(String[] args) throws InterruptedException {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            DocumentTemplate template = container.select(DocumentTemplate.class).get();
            God diana = builder().withId("diana").withName("Diana").withPower("hunt").builder();
            template.insert(diana);

            DocumentQuery query = select().from("god").where("name").eq("Diana").build();

            List<God> result = template.select(query);
            result.forEach(System.out::println);

            template.insert(diana, Duration.ofSeconds(1));
            Thread.sleep(2_000L);
            System.out.println(template.select(query));

        }
    }
}
