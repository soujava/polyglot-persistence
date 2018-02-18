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
package org.jnosql.polyglot;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Objects;

@Entity
public class God {

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String power;

    @Deprecated
    public God() {
    }

    private God(String id, String name, String power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof God)) return false;
        God god = (God) o;
        return Objects.equals(id, god.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("God{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", power='").append(power).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static GodBuilder builder() {
        return new GodBuilder();
    }

    public static class GodBuilder {

        private String id;

        private String name;

        private String power;

        private GodBuilder() {
        }

        public GodBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public GodBuilder withName(String name) {
            this.name = name;
            return this;
        }


        public GodBuilder withPower(String power) {
            this.power = power;
            return this;
        }

        public God builder() {
            return new God(id, name, power);
        }
    }
}
