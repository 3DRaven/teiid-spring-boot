/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.teiid.spring.example;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class, TestConfiguration.class})
public class TestExample {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void test() {
        Employee e = new Employee();
        e.setId(123);
        e.setName("Henry Smith");
        e.setAge(28);
        e.setSalary(new BigDecimal("2000"));
        e.setDesignation("Programmer");
        e.setPhoneNumbers(new long[] { 654321, 222333 });
        Address address = new Address();
        address.setStreet("Park Avn.");
        address.setCity("Westchester");
        address.setZipcode(10583);
        e.setAddress(address);
        assertEquals(e, employeeRepository.findAll().iterator().next());
    }
}
