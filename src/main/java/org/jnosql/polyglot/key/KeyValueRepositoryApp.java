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

package org.jnosql.polyglot.key;


import jakarta.nosql.mapping.keyvalue.KeyValueTemplate;
import org.jnosql.polyglot.God;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Optional;

public class KeyValueRepositoryApp {
    public static void main(String[] args) throws InterruptedException {

        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {

            God diana = new God(1L, "Diana", "Hunt");

            KeyValueTemplate template =
                    container.select(KeyValueTemplate.class)
                            .get();
            template.put(diana);

            final Optional<God> god = template.get(1L, God.class);
            System.out.println("query : " + god);
            template.delete(1L);

            System.out.println("query again: " +
                    template.get(1L, God.class));
        }
        System.exit(0);
    }
}
