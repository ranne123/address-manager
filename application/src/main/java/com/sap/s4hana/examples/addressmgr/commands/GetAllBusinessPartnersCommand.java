package com.sap.s4hana.examples.addressmgr.commands;

import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.Order;
import org.slf4j.Logger;

import java.util.List;

import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;

public class GetAllBusinessPartnersCommand {
    private static final Logger logger = CloudLoggerFactory.getLogger(GetAllBusinessPartnersCommand.class);

    private static final String CATEGORY_PERSON = "1";

    private final BusinessPartnerService service;

    public GetAllBusinessPartnersCommand(final BusinessPartnerService service) {
        this.service = service;
    }

    public List<BusinessPartner> execute() throws Exception {
        // TODO: Replace with Virtual Data Model query
  return service.getAllBusinessPartner()
		  .select(BusinessPartner.BUSINESS_PARTNER,BusinessPartner.LAST_NAME,BusinessPartner.FIRST_NAME)
		  .filter(BusinessPartner.BUSINESS_PARTNER_CATEGORY.eq(CATEGORY_PERSON))
		  .orderBy(BusinessPartner.LAST_NAME, Order.ASC)
		  .execute();
        
    }

}
