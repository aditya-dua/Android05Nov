package com.adityadua.webservicesdemo5n.network;

import com.adityadua.webservicesdemo5n.utils.CommonUtilities;

/**
 * Created by AdityaDua on 27/01/18.
 */

public interface OnWebServiceResult {

    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type);
}
