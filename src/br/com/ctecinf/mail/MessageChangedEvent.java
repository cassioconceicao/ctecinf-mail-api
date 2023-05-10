/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
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

package br.com.ctecinf.mail;

import java.util.*;

/**
 * This class models Message change events.
 *
 * @author John Mani
 */

public class MessageChangedEvent extends MailEvent {

    /** The message's flags changed. */
    public static final int FLAGS_CHANGED 	= 1;
    /** The message's envelope (headers, but not body) changed. */
    public static final int ENVELOPE_CHANGED 	= 2;

    /**
     * The event type.
     *
     * @serial
     */
    protected int type;

    /**
     * The message that changed.
     */
    transient protected Message msg;

    private static final long serialVersionUID = -4974972972105535108L;

    /**
     * Constructor.
     * @param source  	The folder that owns the message
     * @param type	The change type
     * @param msg	The changed message 
     */
    public MessageChangedEvent(Object source, int type, Message msg) {
	super(source);
	this.msg = msg;
	this.type = type;
    }

    /**
     * Return the type of this event.
     * @return  type
     */
    public int getMessageChangeType() {
	return type;
    }

    /**
     * Return the changed Message.
     * @return  the message
     */
    public Message getMessage() {
	return msg;
    }

    /**
     * Invokes the appropriate MessageChangedListener method.
     */
    @Override
    public void dispatch(Object listener) {
	((MessageChangedListener)listener).messageChanged(this);
    }
}