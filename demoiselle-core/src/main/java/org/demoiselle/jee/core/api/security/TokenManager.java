/*
 * Demoiselle Framework
 *
 * License: GNU Lesser General Public License (LGPL), version 3 or later.
 * See the lgpl.txt file in the root directory or <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.demoiselle.jee.core.api.security;

/**
 *
 * Token Management, where we store, create and erase the tokens generated by
 * the app. We have three suggestions for implementation, basic, JWT and memory,
 * but you can implement more is useful for your project or extend existing
 * ones.
 * 
 * @author SERPRO
 */
public interface TokenManager {

    /**
     * Search the logged user being kept place through token use that is in
     * session request
     *
     * @return See {@link DemoisellePrincipal}
     */
    public DemoisellePrincipal getUser();

    /**
     *
     * Stores the user logged in to be used in the next requests at that time it
     * generates a token, depending on the approach, and placed in the token
     * object in the request scoped
     *
     * @param user See {@link DemoisellePrincipal}
     */
    public void setUser(DemoisellePrincipal user);

    /**
     *
     * Remove the user logged
     *
     * @param user See {@link DemoisellePrincipal}
     */
    public void removeUser(DemoisellePrincipal user);

    /**
     * Validates that the user is stored correctly, depending on the chosen
     * strategy.
     *
     * @return Boolean
     */
    public boolean validate();

}
