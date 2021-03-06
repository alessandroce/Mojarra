/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 1997-2016 Oracle and/or its affiliates. All rights reserved.
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
package javax.faces.lifecycle;

import javax.faces.FacesWrapper;
import javax.faces.context.FacesContext;

/**
 * <p class="changed_added_2_2">Create {@link ClientWindow} instances based on 
 * the incoming request.</p>
 * 
 * <p class="changed_added_2_3">Usage: extend this class and push the implementation being wrapped to the
 * constructor and use {@link #getWrapped} to access the instance being wrapped.</p>
 * 
 * @since 2.2
 */
public abstract class ClientWindowFactory implements FacesWrapper<ClientWindowFactory> {

    
    private ClientWindowFactory wrapped;

    /**
     * @deprecated Use the other constructor taking the implementation being wrapped.
     */
    @Deprecated
    public ClientWindowFactory() {
        
    }

    /**
     * <p class="changed_added_2_3">If this factory has been decorated, 
     * the implementation doing the decorating should push the implementation being wrapped to this constructor.
     * The {@link #getWrapped()} will then return the implementation being wrapped.</p>
     * 
     * @param wrapped The implementation being wrapped.
     */
    public ClientWindowFactory(ClientWindowFactory wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * <p class="changed_modified_2_3">If this factory has been decorated, the 
     * implementation doing the decorating may override this method to provide
     * access to the implementation being wrapped.</p>
     */
    @Override
    public ClientWindowFactory getWrapped() {
        return wrapped;
    }

    /**
     * <p class="changed_added_2_2">The implementation is responsible
     * for creating the {@link ClientWindow} instance for this request.
     * If {@link ClientWindow#CLIENT_WINDOW_MODE_PARAM_NAME}
     * is "none" or unspecified, this method must return {@code null}.  
     * If {@link ClientWindow#CLIENT_WINDOW_MODE_PARAM_NAME}
     * is "url" the implementation must return a <code>ClientWindow</code>
     * instance that implements the url-mode semantics described in
     * {@link ClientWindow}.
     * 
     * @param context the {@link FacesContext} for this request.
     * @return the {@link ClientWindow} for this request, or {@code null} 
     * 
     * @since 2.2
     */
    
    public abstract ClientWindow getClientWindow(FacesContext context);
    
}
