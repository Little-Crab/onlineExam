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
        <label class="layui-form-label required">课程号</label>
        <div class="layui-input-block">
            <input type="text" name="courseId" lay-verify="required" lay-reqtext="课程号不能为空" placeholder="请输入课程号" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">课程名称</label>
        <div class="layui-input-block">
            <input type="text" name="courseName" lay-verify="required" lay-reqtext="课程名称不能为空" placeholder="请输入课程名称"
                   value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">班级</label>
        <div class="layui-input-inline">
            <input type="hidden" name="classId" autocomplete="off" class="layui-input" id="classId">
            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input" id="classRadio">
        </div>
    </div>
    <input type="hidden" name="teacherId" autocomplete="off" class="layui-input" value="${sessionScope.admin.id}">

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
        });
        tableSelect.render({
            elem: '#classRadio',
            checkedKey: 'classId',
            table: {
                method: 'POST',
                contentType: 'application/json',
                url: '../class/query',
                cols: [[
                    {type: 'radio'},
                    {field: 'classId', title: '班级号'},
                    {field: 'className', title: '班级名称'}
                ]]
            },
            done: function (elem, data) {
                var NEWJSON = []
                layui.each(data.data, function (index, item) {
                    document.getElementById('classId').value = item.classId;
                    NEWJSON.push(item.className)
                })
                elem.val(NEWJSON.join(","))
            }
        });
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