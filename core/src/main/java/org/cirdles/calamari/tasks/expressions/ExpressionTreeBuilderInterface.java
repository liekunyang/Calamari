/* 
 * Copyright 2006-2017 CIRDLES.org.
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
package org.cirdles.calamari.tasks.expressions;

/**
 *
 * @author James F. Bowring
 */
public interface ExpressionTreeBuilderInterface {

    /**
     * @param operation the operation to set
     */
    public void setOperation(OperationOrFunctionInterface operation);

    /**
     * @return the operation
     */
    public OperationOrFunctionInterface getOperation();

    /**
     * @return the leftET
     */
    public ExpressionTreeInterface getLeftET();

    /**
     * @param leftET the leftET to set
     */
    public void setLeftET(ExpressionTreeInterface leftET);

    /**
     * @return the rightET
     */
    public ExpressionTreeInterface getRightET();

    /**
     * @param rightET the rightET to set
     */
    public void setRightET(ExpressionTreeInterface rightET);
    
    public int getCountOfChildren();

    public int getOperationPrecedence();

}
