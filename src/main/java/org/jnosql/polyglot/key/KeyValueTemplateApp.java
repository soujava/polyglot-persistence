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
package org.jnosql.polyglot.key;

import org.jnosql.artemis.key.KeyValueTemplate;
import org.jnosql.polyglot.God;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.Duration;
import java.util.Collections;
import java.util.Optional;

import static org.jnosql.polyglot.God.builder;

public class KeyValueTemplateApp {
    public static void main(String[] args) throws InterruptedException {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            KeyValueTemplate template = container.select(KeyValueTemplate.class).get();
            God diana = builder().withId("diana").withName("Diana").withPowers(Collections.singleton("hunt")).builder();
            template.put(diana);

            Optional<God> result = template.get("diana", God.class);
            result.ifPresent(System.out::println);

            template.put(diana, Duration.ofSeconds(1));
            Thread.sleep(2_000L);
            System.out.println(template.get("diana", God.class));

        }
    }
}
