package org.java.connectors;


import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class CsvJsonComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri,String remaining, Map<String, Object> parameters) throws Exception
    {
        CsvJsonEndpoint endpoint = new CsvJsonEndpoint(uri, this);

        setProperties(endpoint, parameters);

        return endpoint;
    }
}
