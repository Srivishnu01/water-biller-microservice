package com.main;

import com.remote.mocked.BankAccount;
import com.remote.mocked.WaterBill;
import org.json.simple.JSONObject;
import com.remote.mocked.PostLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");
        String response = "{}";
        PrintWriter out = res.getWriter();
        String username = req.getParameterMap().get("username")[0];
        String password = req.getParameterMap().get("password")[0];

        PostLogin pl = new PostLogin(username, password);
        pl.findUser();
        if(pl.login_status != PostLogin.Login_status.LOGGED_IN)
        {
            JSONObject json = new JSONObject();
            json.put("message", pl.message);
            out.print(json.toString());
            res.setStatus(400);
            return;
        }
        WaterBill b = new WaterBill(username);
        int billAmount = b.fetchBill();

        BankAccount acc = new BankAccount(pl.AccountNumber);
        if(billAmount <= acc.fetchBalance())
        {
            acc.payBill(billAmount);
            JSONObject json = new JSONObject();
            json.put("message","Water bill paid successfully");
            out.print(json.toString());
        }
        else
        {
            JSONObject json = new JSONObject();
            json.put("message", "Insufficient bank balance");
            out.print(json.toString());
        }
    }
}