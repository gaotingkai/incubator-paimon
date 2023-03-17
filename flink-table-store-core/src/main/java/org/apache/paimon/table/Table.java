/*
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

package org.apache.paimon.table;

import org.apache.paimon.table.sink.BatchWriteBuilder;
import org.apache.paimon.table.sink.StreamWriteBuilder;
import org.apache.paimon.table.source.ReadBuilder;
import org.apache.paimon.types.RowType;

import org.apache.paimon.annotation.Experimental;

import java.io.Serializable;
import java.util.Map;

/**
 * A table provides basic abstraction for table type and table scan and table read.
 *
 * @since 0.4.0
 */
@Experimental
public interface Table extends Serializable {

    /** A name to identify this table. */
    String name();

    /** Returns the row type of this table. */
    RowType rowType();

    /** Copy this table with adding dynamic options. */
    Table copy(Map<String, String> dynamicOptions);

    /** Returns a new read builder. */
    ReadBuilder newReadBuilder();

    /** Returns a new batch write builder. */
    BatchWriteBuilder newBatchWriteBuilder();

    /** Returns a new stream write builder. */
    StreamWriteBuilder newStreamWriteBuilder();
}