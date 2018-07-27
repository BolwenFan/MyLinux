package com.atguigu.jedis;

import com.atguigu.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JedisServlet", urlPatterns = "/jedisServlet")
public class JedisServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jedis jedis = JedisUtils.getJedis();
        System.out.println(jedis.ping());
        Long key2 = jedis.incrBy("key2", 5);
        JedisUtils.releaseJedis(jedis);
        request.setAttribute("result", key2);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
