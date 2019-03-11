package com.Gemalto.database.dbUtils;

import com.Gemalto.database.dao.GenericDao;
import com.Gemalto.database.dao.GenericDaoImpl;
import com.Gemalto.models.Link;
import com.Gemalto.models.Project;
import com.Gemalto.models.Tool;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFill {

    public static void fillLinkdatabase() {
        List<Link> linksList = new ArrayList<>();
        GenericDao<Link> genericDao = new GenericDaoImpl<>(Link.class, HibernateUtil.getSessionFactory());
        Link link=new Link("Confluence-Spain", "https://confluence.gemalto.com/display/OEEMEA/Italy-Iberis+Group", "dsds");
        Link link2 = new Link();
        link2.setName("ds");
        link2.setComment("dsada");
        link2.setHiperlink("dsadsa");
        linksList.add(new Link("Tool invetory", "https://confluence.gemalto.com/display/DEA/OE+Tools+Inventory", "dsds"));
        linksList.add(new Link("Rhode-code", "https://vge1hg.gemalto.com/redmine/issues/133856", "dsds"));
        linksList.add(new Link("DHL", "https://www.intrashipeu.dhl.com/intraship/jsp/V7/83qQfalhQs3R7juN3dD67P7s3r9N_xS2uyS_BMh8CWT14cI20q5SR1khPbruXW1h9zIer0O8+1wqL6A0JsXoVuj6GyLajk7zkX56Gj4KNQU-.jsp?IS=1#nbb", "dsds"));
        linksList.add(new Link("Debug-room GUIDE", "https://confluence.gemalto.com/display/OEEMEA/Debug+Room+guide", "dsds"));
        linksList.add(new Link("Dev-rule", "http://gemshare.gemalto.com/secure_transactions/BPA/oe/INTERNAL%20DOCUMENTATION/Forms/AllItems.aspx?RootFolder=/secure_transactions/BPA/oe/INTERNAL%20DOCUMENTATION/DEV%20RULES%20EMEA", "dsds"));
        linksList.add(new Link("Banking Perso", "http://gemapp.gemalto.com/perso/Deployment/Banking%20and%20ID%20Support%20and%20Deployment/BankID_Perso_Download.html", "dsds"));
        linksList.add(new Link("Secure Transaction Product Center", "http://go.gemalto.com/sites/offers/secure-transactions/cards-payment/product-center", "dsds"));
        linksList.add(new Link("Java card specifications", "http://go.gemalto.com/sites/offers/secure-transactions/product-center-PhysicalSite/Pages/Javacard_specs_page.aspx", "dsds"));
        linksList.add(new Link("Cryptography", "http://go.gemalto.com/sites/offers/secure-transactions/product-center-PhysicalSite/Pages/Cryptography_page.aspx", "dsds"));
        linksList.add(new Link("DEBUG-ROOM UPLOAD FILES", "https://admin.allynisconnect.gemalto.com/transferlogs", "dsds"));
        linksList.add(new Link("DEBUG-ROOM SEARCHING FILES", "https://emea.allynisconnect.gemalto.com/wt/", "dsds"));
        linksList.add(new Link("OE Security", "https://confluence.gemalto.com/display/TCDSecurity/OE+Security", "dsds"));
        linksList.add(new Link("SECURITY-USEFUL LINKS", "https://confluence.gemalto.com/display/TCDSecurity/Useful+links", "dsds"));
        linksList.add(new Link("siema", "hdsadas", "dsds"));
        genericDao.save(link2);
        linksList.forEach(e->{
            genericDao.save(e);
        });
        HibernateUtil.shutdown();
    }

    public static void fillToolDatabase(){
        GenericDao<Tool> genericDao = new GenericDaoImpl<>(Tool.class, HibernateUtil.getSessionFactory());
        List<Tool> toolList = new ArrayList<>();
        toolList.add(new Tool("GPC", "The latest version is 4.5"));
        toolList.add(new Tool("SmartGpc", "none"));
        toolList.add(new Tool("Magtek", "no comment"));
        toolList.forEach(e->{
            genericDao.save(e);
        });
        HibernateUtil.shutdown();
    }

    public static void fillKRSDatabase(){
        GenericDao<Project> genericDao = new GenericDaoImpl<>(Project.class, HibernateUtil.getSessionFactory());
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("Santander-MAIN","D1331589","D1336238","S1192956","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A2941892135&u8=1","NO COMMENT"));
        projectList.add(new Project("Santander Consumer Finance","S1200219","D1340537","D1338620","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.doc.WTDocument%3A2975632890&u8=1","NP"));
        projectList.add(new Project("Santander University Instant Issuance","D1335478","D1336704","S1150681 (PC)","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A2745514602&u8=1","NP"));
        projectList.add(new Project("Sodexo","D1366380","D1371995","S1166046","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=VR%3Awt.part.WTPart%3A2904279396&u8=1","NP"));
        projectList.add(new Project("M2P","D1322160","D1451626","S1146110","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A2092462439&u8=1","NP"));
        projectList.add(new Project("Edenred","D1264715","D1269422","S1122038 (PC)","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A2831835237&u8=1","NP"));
        projectList.add(new Project("Finconsum","D1257924","D1228897","S1206485","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A2971577453&u8=1","NP"));
        projectList.add(new Project("ARQUIA_OBE","D1408096","D1411998","S1182495","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=VR%3Awt.part.WTPart%3A1891788183&u8=1","NP"));
        projectList.add(new Project("ARQUIA-EMV","D1141330","D1358204","S1160335","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=VR%3Awt.part.WTPart%3A2435951699&u8=1","NP"));
        projectList.add(new Project("AvantCard","D1256631","D1237307","S1108651","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A1603457647&u8=1","NP"));
        projectList.add(new Project("Bankinter","D1261524","D1273261","S1192956","https://www2.pdm.gemalto.com/Windchill/app/#ptc1/tcomp/infoPage?oid=OR%3Awt.part.WTPart%3A2941892135&u8=1","NP"));


        projectList.forEach(e->{
            genericDao.save(e);
        });
        HibernateUtil.shutdown();
    }

}
