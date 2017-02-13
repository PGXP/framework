/*
 * Demoiselle Framework
 *
 * License: GNU Lesser General Public License (LGPL), version 3 or later.
 * See the lgpl.txt file in the root directory or <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.demoiselle.jee.crud.filter;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.UriInfo;

import org.demoiselle.jee.crud.CrudMessage;
import org.demoiselle.jee.crud.CrudUtilHelper;
import org.demoiselle.jee.crud.DemoiselleRequestContext;
import org.demoiselle.jee.crud.ReservedKeyWords;
import org.demoiselle.jee.crud.field.TreeNodeField;

/**
 * @author SERPRO
 *
 */
@RequestScoped
public class FilterHelper {
    
    private UriInfo uriInfo;
    
    private ResourceInfo resourceInfo;
    
    @Inject
    private DemoiselleRequestContext drc;
    
    @Inject
    private CrudMessage crudMessage;
    
    public FilterHelper(){}
    
    public FilterHelper(ResourceInfo resourceInfo, UriInfo uriInfo, DemoiselleRequestContext drc, CrudMessage crudMessage){
        this.uriInfo = uriInfo;
        this.resourceInfo = resourceInfo;
        this.drc = drc;
        this.crudMessage = crudMessage;
    }
    
    public void execute(ResourceInfo resourceInfo, UriInfo uriInfo) {
        this.resourceInfo = resourceInfo == null ? this.resourceInfo : resourceInfo;
        this.uriInfo = uriInfo == null ? this.uriInfo : uriInfo;
        
        Map<String, Set<String>> filters = new ConcurrentHashMap<>(5);
        
        uriInfo.getQueryParameters().forEach((key, values) ->{
            if(!isReservedKey(key)){
                Set<String> paramValues = new LinkedHashSet<>();
                
                values.stream().forEach(value -> {
                    paramValues.addAll(CrudUtilHelper.extractFields(value));
                });
                
                filters.put(key, paramValues);
            }
        });
        
        TreeNodeField<String, Set<String>> tnf = new TreeNodeField<>(CrudUtilHelper.getTargetClass(this.resourceInfo.getResourceClass()).getName(), ConcurrentHashMap.newKeySet(1));
        
        if(!filters.isEmpty()){
            filters.forEach( (key, value) ->
                CrudUtilHelper.fillLeafTreeNodeField(tnf, key, value)
            );
            
            CrudUtilHelper.validateFields(tnf, this.resourceInfo, this.crudMessage);
            
            drc.setFilters(tnf);
            
            System.out.println(drc.getFilters().containsKey("mail"));
        }
        
    }

    private Boolean isReservedKey(String key) {
        return key.equalsIgnoreCase(ReservedKeyWords.DEFAULT_RANGE_KEY.getKey()) 
                || key.equalsIgnoreCase(ReservedKeyWords.DEFAULT_SORT_DESC_KEY.getKey()) 
                || key.equalsIgnoreCase(ReservedKeyWords.DEFAULT_SORT_KEY.getKey())
                || key.equalsIgnoreCase(ReservedKeyWords.DEFAULT_FIELD_KEY.getKey());
    }
}
