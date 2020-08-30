package com.suprun.criteria.controller;

import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.Oven;
import com.suprun.criteria.entity.TabletPC;
import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.entity.criteria.SearchCriteria;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ApplianceControllerTest {

    ApplianceController applianceController;

    @BeforeClass
    public void beforeClass() {
        applianceController = ApplianceController.getInstance();
    }

    @DataProvider
    public static Object[][] findProcessRequest() {
        return new Object[][]{{new Criteria("FIND_BY_PARAMETER", "Oven") {{
            add(SearchCriteria.Oven.CAPACITY.toString(), "33");
        }}, new HashMap<String, Object>() {{
            put("appliances", new ArrayList<Appliance>() {{
                add(new Oven(1500, 12, 33, 60, 45, 68));
                add(new Oven(2000, 11, 33, 60, 40, 70));
            }});
        }}},
                {new Criteria("FIND_BY_PARAMETER", "Oven") {{
                    add(SearchCriteria.Oven.HEIGHT.toString(), "40");
                    add(SearchCriteria.Oven.DEPTH.toString(), "60");
                }},
                        new HashMap<String, Object>() {{
                            put("appliances", new ArrayList<Appliance>() {{
                                add(new Oven(2000, 11, 33, 60, 40, 70));
                            }});
                        }}},
                {new Criteria("FIND_BY_PARAMETER", "TabletPC") {{
                    add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
                    add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), "14");
                    add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), "8000");
                }},
                        new HashMap<String, Object>() {{
                            put("appliances", new ArrayList<Appliance>() {{
                                add(new TabletPC(3.0, 14, 8000, 2, TabletPC.Color.BLUE));
                            }});
                        }}}};
    }

    @Test(dataProvider = "findProcessRequest")
    public void testFindProcessRequest(Criteria request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = applianceController.processRequest(request);
        assertEquals(actual, expectedResult);
    }
}