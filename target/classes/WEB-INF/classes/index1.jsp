<%@ page import="Dao.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.Object" %>
<!DOCTYPE html>

<html class="iframe-h">
<%@ page contentType="text/html; charset=utf-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>百度分类浏览</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css"/>
</head>

<body>
<div class="wrap-container clearfix">
    <div class="column-content-detail">
        <form class="layui-form" action="PageServlet" method="post">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <select name="states" lay-filter="status" id="selectType">
                        <option>请选择关键词</option>
                        <option>网页</option>
                        <option>热搜推荐</option>
                        <option>头条</option>
                        <option>社会</option>
                        <option>娱乐</option>
                        <option>生活</option>
                        <option>体育</option>
                        <option>热播</option>
                        <option>热剧</option>
                        <option>电影</option>
                        <option>综艺</option>
                        <option>动漫</option>
                        <option>热门</option>
                        <option>游戏</option>
                        <option>页游</option>
                        <option>单机</option>
                        <option>手游</option>
                        <option>购物</option>
                        <option>团购</option>
                        <option>特卖</option>
                        <option>9块9</option>
                        <option>海淘</option>
                        <option>常用站点</option>
                        <option>实用工具</option>
                        <option>视频</option>
                        <option>影视</option>
                        <option>游戏</option>
                        <option>新闻</option>
                        <option>看点</option>
                        <option>体育</option>
                        <option>购物</option>
                        <option>商城</option>
                        <option>旅游</option>
                        <option>小说</option>
                        <option>手机</option>
                        <option>社交</option>
                        <option>直播</option>
                        <option>生活</option>
                        <option>软件</option>
                        <option>直 播</option>
                        <option>招聘</option>
                        <option>汽车</option>
                        <option>页游</option>
                        <option>网游</option>
                        <option>动漫</option>
                        <option>音乐</option>
                        <option>金融</option>
                        <option>财经</option>
                        <option>邮箱</option>
                        <option>女性</option>
                        <option>彩票</option>
                        <option>银行</option>
                        <option>酷站</option>
                        <option>实用</option>
                        <option>生活服务</option>
                        <option>娱乐休闲</option>
                        <option>地方网站</option>
                        <option>其他类别</option>
                    </select>
                </div>
                <button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
            </div>
        <div class="layui-form" id="table-list">
            <table class="layui-table" lay-even lay-skin="nob">
                <thead>
                <tr>
                    <th>分类</th>
                    <th>标题</th>
                    <th>链接</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Page> list = (List<Page>) request.getAttribute("list");
                    for (Page page1 : list) {
                %>
                <tr>
                    <td><%=page1.getType()%></td>
                    <td><%=page1.getContent()%></td>
                    <td><a href="<%=page1.getLink()%>" style="color: #00a0e9">戳我！</a></td>

                <%
                    }
                %>
                </tbody>
            </table>
            <%--<div class="page-wrap">--%>
                <%--<ul class="pagination">--%>
                    <%--<li class="disabled"><span>«</span></li>--%>
                    <%--<li class="active"><span>1</span></li>--%>
                    <%--<li>--%>
                        <%--<a href="#">2</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">»</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>
        </form>
    </div>

</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>