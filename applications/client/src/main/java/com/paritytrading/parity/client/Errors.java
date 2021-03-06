/*
 * Copyright 2014 Parity authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.parity.client;

import java.util.ArrayList;
import java.util.List;

class Errors extends DefaultEventVisitor {

    private final List<Error> errors;

    private Errors() {
        errors = new ArrayList<>();
    }

    static List<Error> collect(Events events) {
        Errors visitor = new Errors();

        events.accept(visitor);

        return visitor.getEvents();
    }

    private List<Error> getEvents() {
        return errors;
    }

    @Override
    public void visit(Event.OrderRejected event) {
        errors.add(new Error(event));
    }

}
