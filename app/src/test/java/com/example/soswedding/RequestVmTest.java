package com.example.soswedding;
import com.example.soswedding.model.Request;
import com.example.soswedding.ui.all_requests.AllRequestsViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RequestVmTest {

    private AllRequestsViewModel viewModel;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        viewModel = new AllRequestsViewModel();
    }
    @Test
    public void getRequestsObjectForCoupleNullTest(){
        String json = mockBidObject();
        ArrayList<Request> rq = (ArrayList<Request>) viewModel.getListOfAllRequests(json);
        assertEquals(rq.get(0).getAddress(), "Montreal");
        assertEquals(rq.get(0).getType(), "DANCER");
        assertEquals(String.valueOf(rq.get(0).getBudget()), "1.0");
        assertEquals(rq.get(0).getTitle(), "test");
        assertEquals(rq.get(0).getDescription(), "test");
    }

    public String mockBidObject(){
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        try {
            item.put("address", "Montreal");
            item.put("description", "test");
            item.put("serviceType", "DANCER");
            item.put("budget", "1.0");
            item.put("title", "test");
            array.put(item);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonArray = array.toString();

        return jsonArray;
    }
}