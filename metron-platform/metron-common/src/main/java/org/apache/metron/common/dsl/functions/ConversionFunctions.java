/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.metron.common.dsl.functions;

import org.apache.metron.common.dsl.BaseStellarFunction;
import org.apache.metron.common.dsl.Stellar;
import org.apache.metron.common.utils.ConversionUtils;

import java.util.List;

public class ConversionFunctions {

  public static class Cast<T> extends BaseStellarFunction {
    Class<T> clazz;
    public Cast(Class<T> clazz) {
      this.clazz = clazz;
    }

    @Override
    public Object apply(List<Object> strings ) {
      return strings.get(0) == null?null: ConversionUtils.convert(strings.get(0), clazz);
    }
  }

  @Stellar(name="TO_INTEGER"
          , description="Transforms the first argument to an integer"
          , params = { "input - Object of string or numeric type"}
          , returns = "Integer version of the first argument"
          )
  public static class TO_INTEGER extends Cast<Integer> {

    public TO_INTEGER() {
      super(Integer.class);
    }
  }

  @Stellar(name="TO_DOUBLE"
          , description="Transforms the first argument to a double precision number"
          , params = { "input - Object of string or numeric type"}
          , returns = "Double version of the first argument"
          )
  public static class TO_DOUBLE extends Cast<Double> {

    public TO_DOUBLE() {
      super(Double.class);
    }
  }
}
