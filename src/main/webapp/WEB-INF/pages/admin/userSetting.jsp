<%--
  Created by IntelliJ IDEA.
  User: Little_Crab
  Date: 2021/4/13
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>基本资料</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {
            width: auto;
            padding-right: 10px;
            line-height: 38px;
        }
    </style>
</head>
<body>
<div class="layuimini-container using">
    <div class="layui-form layuimini-main">
        <div class="layui-form-item">
            <label class="layui-form-label required">设置头像</label>
            <div class="layui-upload-drag " id="test10">
                <div class="" id="uploadDemoView">
                    <hr>
                    <img src="../static/headimage/${sessionScope.admin.headImg}" alt="上传成功后渲染" style="max-width: 196px">
                </div>
                <i class="layui-icon"></i>
                <p>点击上传，或将文件拖拽到此处</p>
                <input type="hidden" name="headImg" id="headImg" value="${sessionScope.admin.headImg}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">账户</label>
            <div class="layui-input-inline">
                <input type="text" name="id" lay-verify="required" value="${sessionScope.admin.id}"
                       readonly="true" class="layui-input" contenteditable="false">
            </div>
            <label class="layui-form-label required">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" class="layui-input"
                       value="${sessionScope.admin.name}" contenteditable="false" readonly="true">
            </div>
            <input type="hidden" name="password" lay-verify="required" class="layui-input"
                   value="${sessionScope.admin.password}" contenteditable="false" readonly="true">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">性别</label>
            <div class="layui-input-inline">
                <input type="hidden" name="sex" lay-verify="required" class="layui-input"
                       value="${sessionScope.admin.sex}" contenteditable="false" readonly="true">
                <input type="text" name="" lay-verify="required" class="layui-input"
                       value="${sessionScope.admin.sex==0?'女':'男'}" contenteditable="false" readonly="true">
            </div>
            <label class="layui-form-label required">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" lay-verify="required" class="layui-input"
                       value="${sessionScope.admin.age}" contenteditable="false" readonly="true">
            </div>
        </div>
        <div class="layui-form-item layui-inline">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input type="text" name="birthday" id="birthday" lay-verify="date"
                       placeholder="yyyy-MM-dd" readonly="true" value="${sessionScope.admin.birthday}"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">年级</label>
            <div class="layui-input-inline">
                <input type="text" name="grade" lay-verify="required" class="layui-input"
                       value="${sessionScope.admin.grade}" contenteditable="false" readonly="true">
            </div>
            <label class="layui-form-label">学院</label>
            <div class="layui-input-inline">
                <input type="hidden" name="deptId" value="${sessionScope.admin.department.deptId}"
                       class="layui-input" readonly="true" contenteditable="false">
                <input type="text" name="" value="${sessionScope.admin.department.deptName}"
                       class="layui-input" readonly="true" contenteditable="false">
            </div>
            <label class="layui-form-label">专业</label>
            <div class="layui-input-inline">
                <input type="hidden" name="majorId" value="${sessionScope.admin.major.majorId}"
                       class="layui-input" readonly="true" contenteditable="false">
                <input type="text" name="" value="${sessionScope.admin.major.majorName}"
                       class="layui-input " readonly="true" contenteditable="false">
            </div>
            <label class="layui-form-label">班级</label>
            <div class="layui-input-inline">
                <input type="hidden" name="classId" value="${sessionScope.admin.class_exam.classId}"
                       class="layui-input" readonly="true" contenteditable="false">
                <input type="text" name="" value="${sessionScope.admin.class_exam.className}"
                       class="layui-input" readonly="true" contenteditable="false">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-inline">
                <input type="text" name="idcard" value="${sessionScope.admin.idcard}" class="layui-input"
                       contenteditable="false" readonly="true">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label required">手机</label>
            <div class="layui-input-inline">
                <input type="number" name="phone" lay-reqtext="手机不能为空" placeholder="请输入手机" id="phone"
                       value="${sessionScope.admin.phone}" class="layui-input" readonly="true"
                       contenteditable="true">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="email" name="email" placeholder="请输入邮箱" value="${sessionScope.admin.email}"
                       class="layui-input" readonly="true" contenteditable="true" id="email">
            </div>
        </div>
        <div class="layui-input-inline">
            <input type="hidden" name="identitytype" value="${sessionScope.admin.identitytype}"
                   class="layui-input" readonly="true" contenteditable="true">
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" id="edit" lay-event="add">
                    编辑
                </button>
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn hide" id="save" lay-submit
                        lay-filter="saveBtn">保存
                </button>
            </div>
        </div>
    </div>
</div>
</div>
<script src="../static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script src="../static/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="UTF-8"></script>
<script>
    layui.use(['jquery', 'form', 'miniTab', 'laydate', 'upload'], function () {
        var form = layui.form,
            layer = layui.layer,
            miniTab = layui.miniTab,
            laydate = layui.laydate,
            $ = layui.jquery, upload = layui.upload;

        laydate.render({
            elem: '#birthday',
            type: 'date'
        })

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = parent.layer.getFrameIndex(window.name);

            data = data.field;
            console.log(JSON.stringify(data))
            $("#phone").prop("readonly", true);
            $("#email").prop("readonly", true);
            $("#save").hide();
            $("#edit").show();
            $.ajax({
                url: "update",
                contentType: "application/json",
                dataType: "json",
                method: "post",
                data: JSON.stringify(data),
                success: function (data) {
                    layer.msg(data.msg, {
                        time: 500
                    }, function () {
                        window.parent.location.reload();

                    });
                }
            })
            return false;
        });
        $("#edit").click(function () {
            $("#phone").prop("readonly", false);
            $("#email").prop("readonly", false);
            $("#edit").hide();
            $("#save").show();
        })

//拖拽上传
        upload.render({
            elem: '#test10'
            , url: 'upload' //改成您自己的上传接口
            , before: function (obj) {
                obj.preview(function (index, file, result) {
                    // layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src', result);
                    layui.$('#uploadDemoView').find('img').attr('src', result);
                    console.log(res)
                });
            },
            done: function (res) {
                layer.msg('上传成功');
                console.log(res)
                var mes = eval("(" + JSON.stringify(res.data) + ")");
                console.log(mes);
                $('#headImg').val(mes.filename);
            }
        });
        /*upload.render({
            elem: '#test1'
            , url: 'upload'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                var mes = eval("(" + JSON.stringify(res.data) + ")");

                console.log(mes);
                $('#headImg').val(mes.filename);
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });*/


    });
</script>
</body>
</html>
