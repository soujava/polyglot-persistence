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
package org.jnosql.polyglot.graph;

import org.jnosql.artemis.DatabaseQualifier;
import org.jnosql.polyglot.God;
import org.jnosql.polyglot.GodRepository;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Collections;
import java.util.Optional;

import static org.jnosql.polyglot.God.builder;

public class GraphRepositoryApp {
    public static void main(String[] args) throws InterruptedException {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            GodRepository repository = container.select(GodRepository.class, DatabaseQualifier.ofGraph()).get();
            God diana = builder().withId("diana").withName("Diana").withPowers(Collections.singleton("hunt")).builder();
            repository.save(diana);

            Optional<God> result = repository.findById("diana");
            result.ifPresent(System.out::println);


        }
    }
}
