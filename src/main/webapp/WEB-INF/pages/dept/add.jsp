<%--
  Created by IntelliJ IDEA.
  User: Little_Crab
  Date: 2021/4/13
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">学院号</label>
        <div class="layui-input-block">
            <input type="text" name="deptId" lay-verify="required" lay-reqtext="学院号不能为空" placeholder="请输入学院号" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">学院名称</label>
        <div class="layui-input-block">
            <input type="text" name="deptName" lay-verify="required" lay-reqtext="学院名称不能为空" placeholder="请输入名称" value=""
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="../static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'tableSelect', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer, $ = layui.$,
            table = layui.table, tableSelect = layui.tableSelect, laydate = layui.laydate;
        laydate.render({
            elem: '#birthday',
            type: 'date'
        })
        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = parent.layer.getFrameIndex(window.name);

            $.ajax({
                url: "create",
                type: "Post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(data.field),
                success: function (data) {
                    layer.msg(data.msg, {
                        time: 500
                    }, function () {
                        parent.layer.close(index);
                    });
                }
            });
            return false;
        });
    });
</script>
</body>
</html>