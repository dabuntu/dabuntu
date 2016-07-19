package com.eventshop.eventshoplinux.servlets;

import com.eventshop.eventshoplinux.model.Emage;
import com.eventshop.eventshoplinux.util.commonUtil.Config;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static com.eventshop.eventshoplinux.constant.Constant.DS_JSON_LOC;
import static com.eventshop.eventshoplinux.constant.Constant.QUERY_JSON_LOC;

/**
 * Created by aravindh on 11/4/15.
 */
public class ReturnEmage {
    public Emage getEmage (String sourceId, int layerId) {
        ObjectMapper mapper = new ObjectMapper();
        Emage emage = null;
        try {
            if (sourceId.startsWith("ds")) {
                emage = mapper.readValue(new File(DS_JSON_LOC + sourceId + "_layer" + layerId + ".json"), Emage.class);
            } else if (sourceId.startsWith("q")) {
                emage = mapper.readValue(new File(QUERY_JSON_LOC + sourceId + "_layer" + layerId + ".json"), Emage.class);

            }
            //return emage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emage;
    }
}
