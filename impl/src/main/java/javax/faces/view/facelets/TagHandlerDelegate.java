/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.faces.view.facelets;

import java.io.IOException;
import javax.faces.component.UIComponent;


/**
 * <p class="changed_added_2_0"><span class="changed_modified_2_2">Abstract</span>
 * class that defines methods
 * relating to helping tag handler instances.  This abstraction enables
 * implementation details to be hidden by the JSF implementation while
 * still allowing concrete classes to be defined for extension by
 * users.</p>
 * 
 * @since 2.0
 */

public abstract class TagHandlerDelegate {

    /**
     * <p class="changed_added_2_0">Return a {@link MetaRuleset}
     * particular to this kind of tag handler.  Called from classes that
     * implement {@link MetaTagHandler}.</p>
     *
     * @param type the <code>Class</code> for which the
     * <code>MetaRuleset</code> must be created.
     * 
     * @return a {@link MetaRuleset} particular to this kind of tag handler. 
     *
     * @since 2.0
     */ 
    
    public abstract MetaRuleset createMetaRuleset(Class type);
    

    /**
     * <p class="changed_added_2_0"><span class="changed_modified_2_2">Called</span>
     * by classes that implement
     * {@link javax.faces.view.facelets.FaceletHandler} in their
     * implementation of <code>apply()</code>.</p>
     * 
     * <p class="changed_added_2_2">If the argument {@code comp} is new to the
     * view, for each tag attribute declared to be in the pass through attribute
     * namespace, set the name and value of the attribute into the pass through
     * attributes map of the component.  See {@link UIComponent#getPassThroughAttributes(boolean) }.
     * See the VDLDocs for the namespace URI of the pass through attribute 
     * namespace.  Attributes whose value is a {@code ValueExpression}
     * must remain un-evaluated and stored in the map as {@code ValueExpression} instances.</p>
     *
     * @param ctx the <code>FaceletContext</code> for this request
     *
     * @param comp the <code>UIComponent</code> that corresponds to this
     * element.
     * 
     * @throws IOException if any files necessary to apply this tag handler 
     * have any difficulty while loading
     *
     */
    public abstract void apply(FaceletContext ctx, UIComponent comp)
    throws IOException;

}
