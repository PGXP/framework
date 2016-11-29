/*
 * Demoiselle Framework
 *
 * License: GNU Lesser General Public License (LGPL), version 3 or later.
 * See the lgpl.txt file in the root directory or <https://www.gnu.org/licenses/lgpl.html>.
 */
package org.demoiselle.jee.multitenancy.hibernate.configuration;

import org.demoiselle.jee.configuration.annotation.Configuration;

/**
 * Class with ALL required configurations for Multitenancy module in Framework
 * Demoiselle.
 * 
 * @author SERPRO
 *
 */
@Configuration
public class MultiTenancyConfiguration {

	private String multiTenancySetDatabaseSQL;

	private String multiTenancyCreateDatabaseSQL;

	private String multiTenancyDropDatabaseSQL;

	private String multiTenancyTenantDatabasePrefix;

	private String multiTenancyTenantsDatabaseDatasource;

	private String multiTenancyMasterDatabaseDatasource;

	private String multiTenancyCreateDatabaseDDL;

	private String multiTenancyDropDatabaseDDL;

	private String multiTenancyMasterDatabase;

	public String getMultiTenancySetDatabaseSQL() {
		return multiTenancySetDatabaseSQL;
	}

	public String getMultiTenancyCreateDatabaseSQL() {
		return multiTenancyCreateDatabaseSQL;
	}

	public String getMultiTenancyDropDatabaseSQL() {
		return multiTenancyDropDatabaseSQL;
	}

	public String getMultiTenancyTenantDatabasePrefix() {
		return multiTenancyTenantDatabasePrefix;
	}

	public String getMultiTenancyTenantsDatabaseDatasource() {
		return multiTenancyTenantsDatabaseDatasource;
	}

	public String getMultiTenancyMasterDatabaseDatasource() {
		return multiTenancyMasterDatabaseDatasource;
	}

	public String getMultiTenancyCreateDatabaseDDL() {
		return multiTenancyCreateDatabaseDDL;
	}

	public String getMultiTenancyDropDatabaseDDL() {
		return multiTenancyDropDatabaseDDL;
	}

	public String getMultiTenancyMasterDatabase() {
		return multiTenancyMasterDatabase;
	}

}