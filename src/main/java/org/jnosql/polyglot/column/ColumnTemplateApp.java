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


import jakarta.nosql.mapping.column.ColumnTemplate;
import org.jnosql.polyglot.God;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ColumnTemplateApp {
    public static void main(String[] args) throws InterruptedException {

        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {

            God diana = new God(1L, "Diana", "Hunt");

            ColumnTemplate template =
                    container.select(ColumnTemplate.class)
                            .get();
            template.insert(diana, Duration.ofSeconds(1L));

            final Optional<God> god = template.find(God.class, 1L);
            System.out.println("query : " + god);
            TimeUnit.SECONDS.sleep(2L);

            System.out.println("query again: " +
                    template.find(God.class, 1L));
        }
        System.exit(0);
    }
}
