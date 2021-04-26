<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/lib/layui-src/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/question.css" media="all">
</head>
<body>
<div class="layuimini-container"
     style="position: absolute;bottom: 0px;top: 0px;background-color: #F2F2F2;left: 0px;right:0px;margin: 10px;">
    <div class="left">
        <ul>
            <li>
                <a href="javascript:void(0)" class="radio_type">
                    <i class="layui-icon layui-icon-about"></i>
                    单选题
                </a>
            </li>
            <li>
                <a href="javascript:void(0)" class="checkbox_type">
                    <i class="layui-icon layui-icon-about"></i>
                    多选题
                </a>
            </li>
            <li>
                <a href="javascript:void(0)" class="input_type">
                    <i class="layui-icon layui-icon-about"></i>
                    简答题
                </a>
            </li>
            <%--<li>
                <a href="javascript:void(0)" class="text_type">
                    <i class="layui-icon layui-icon-about"></i>
                    问答题
                </a>
            </li>--%>
        </ul>
    </div>
    <div class="main" id="main" style="overflow: auto">
        <ul class="content">
        </ul>
    </div>
</div>

<div class="radioTemplate" style="display: none">
    <li class="using radio">
        <input type="hidden">
        <div class="title">
            <div class="edit" contenteditable="true">标题</div>
            <div class="edit" contenteditable="true">描述</div>
        </div>
        <div class="required">
            分值
            <span class="edit scorevalue" contenteditable="true" style="width: 60px;padding: 7px 20px;">5</span>
            答案选项
            <span class="edit  answer" title="答案序号" contenteditable="true"
                  style="width: 60px;padding: 7px 20px;">1</span>
        </div>
        <div class="options">
            <div class="edit" contenteditable="true">选项</div>
            <div class="edit" contenteditable="true">选项</div>
            <div class="edit" contenteditable="true">选项</div>
            <div class="edit" contenteditable="true">选项</div>
        </div>
        <div class="que-btn">
            <button class="layui-btn layui-btn-primary layui-btn-sm data-add-btn mydel" lay-event="add"> 取消</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn myedit hide" lay-event="add"> 编辑
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysave" lay-event="add"> 保存</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysaveitem" lay-event="addItem"> 新增选项
            </button>
            <span class="layui-text">编辑状态下，双击选项删除</span>
        </div>
    </li>
</div>

<div class="checkboxTemplate" style="display: none">
    <li class="using checkbox">
        <input type="hidden">
        <div class="title">
            <div class="edit" contenteditable="true">标题</div>
            <div class="edit" contenteditable="true">描述</div>
        </div>
        <div class="required">
            分值
            <span class="edit  scorevalue" contenteditable="true" style="width: 60px;padding: 7px 20px;">5</span>
            答案选项
            <span class="edit answer" title="答案序号" contenteditable="true"
                  style="width: 60px;padding: 7px 20px;">1</span>
        </div>
        <div class="options">
            <div class="edit" contenteditable="true">选项</div>
            <div class="edit" contenteditable="true">选项</div>
            <div class="edit" contenteditable="true">选项</div>
            <div class="edit" contenteditable="true">选项</div>
        </div>
        <div class="que-btn">
            <button class="layui-btn layui-btn-primary layui-btn-sm data-add-btn mydel" lay-event="add"> 取消</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn myedit hide" lay-event="add"> 编辑
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysave" lay-event="add"> 保存</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysaveitem" lay-event="addItem"> 新增选项
            </button>
            <span class="layui-text">编辑状态下，双击选项删除</span>
        </div>
    </li>
</div>
<div class="inputTemplate" style="display: none">
    <li class="using inputx">
        <input type="hidden">
        <div class="title">
            <div class="edit" contenteditable="true">标题</div>
            <div class="edit" contenteditable="true">描述</div>
        </div>
        <div class="required">
            分值
            <span class="edit  scorevalue" contenteditable="true" style="width: 60px;padding: 7px 20px;">5</span>

        </div>
        <div class="result">
            <div class="edit resultAnswer" contenteditable="true"></div>
        </div>
        <div class="que-btn">
            <button class="layui-btn layui-btn-primary layui-btn-sm data-add-btn mydel" lay-event="add"> 取消</button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn myedit hide" lay-event="add"> 编辑
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysave" lay-event="add"> 保存</button>
        </div>
    </li>
</div>
<%--<div class="textTemplate" style="display: none">
    <li class="using">
        <input type="hidden">
        <div class="title">
            <div class="edit" contenteditable="true">标题</div>
            <div class="edit" contenteditable="true">描述</div>
        </div>
        <div class="required">
            <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i
                    class="layui-icon layui-icon-ok"></i></div>
            必填项
        </div>
        <div class="mores">
            <div class="more">
                <div class="edit" name="questionMoreTitle" contenteditable="true">小题标题</div>
                <div class="edit" name="questionMoreResult" contenteditable="true">小题答案</div>
                <br>
            </div>
        </div>
        <div class="que-btn">
            <button class="layui-btn layui-btn-primary layui-btn-sm data-add-btn mydel" lay-event="add"> 取消
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn myedit hide" lay-event="add"> 编辑
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysave" lay-event="add"> 保存
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn mysaveitem2" lay-event="addItem"> 新增选项
            </button>
        </div>
    </li>
</div>--%>
<script src="../static/lib/layui-src/layui.js" charset="utf-8"></script>
<script src="../static/js/lay-config.js" charset="utf-8"></script>
<script>
    layui.use(['jquery', 'layer'], function () {
        let $ = layui.jquery, layer = layui.layer;
        $('.radio_type,.checkbox_type,.input_type,.text_type').on('click', function () {
            if (isEditing()) {
                layer.msg("正在编辑，请先保存");
                return;
            }
            $('.content').find(".using").removeClass("using");
            let template = loadTemplation($(this).prop("className"));
            $('.content').append($(template));
            $('#main').animate({scrollTop: $(".content").height()}, 300);
        });

        //删除操作
        $(".content").on('click', '.mydel', function () {
            //判断是否是当前编辑项
            var flag = $(this).parent().parent().hasClass("using");
            if (flag) {
                $(this).parent().parent().remove();
            } else {
                if (isEditing()) {
                    layer.msg("正在编辑，请先保存");
                    return;
                } else {
                    $(this).parent().parent().remove();
                }
            }
            //清除using状态
            clearUsing();

            var id = $(this).parent().parent().find("input").val();
            if (id) {
                $.ajax({
                    url: "../question/delete",
                    type: "POST",
                    data: "ids=" + id,
                    dataType: 'json',
                    success: function (data) {
                        layer.msg("删除成功");
                    }
                })
            }

        });


        //判断是否有正在编辑的项目
        function isEditing() {
            var length = $('.content').find(".using").length;
            if (length == 0) {
                return false;
            } else {
                return true;
            }
        }

        //保存之后，清除保存状态
        function clearUsing() {
            var obj = $('.content').find(".using");
            obj.removeClass("using");
        }

        //保存操作
        $(".content").on('click', '.mysave', function () {
            var obj = $(this).parents(".using");
            obj.find(".edit").prop("contenteditable", false);
            obj.find(".edit").removeClass("edit").addClass("no_edit");
            //隐藏
            obj.find('.mysave').hide();
            obj.find('.mysaveitem').hide();
            obj.find('.myedit').show();
            clearUsing();

            //写入数据库
            save(obj);
        });

        init();

        function init() {
            var param = {};
            param.examId = ${exam.id};
            $.ajax({
                url: "../question/query",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(param),
                dataType: 'json',
                success: function (data) {
                    var arr = data.data;
                    for (var index = 0; index < arr.length; index++) {
                        switch (arr[index].type) {
                            case 1:
                                loadRadio(1, arr, index);
                                break;
                            case 2:
                                loadRadio(2, arr, index);
                                break;
                            case 3:
                                loadText(3, arr, index);
                                break;
                            case 4:
                                loadText(4, arr, index);
                                break;
                        }
                    }
                }
            })
        }

        function loadRadio(type, arr, index) {
            let template;
            if (type == 1) {
                template = $($('.radioTemplate').html());
            } else if (type == 2) {
                template = $($('.checkboxTemplate').html());
            }
            //设置为div为非编辑状态
            template.find("div .edit").prop("contenteditable", false);
            template.removeClass("using");
            template.find("div .edit").removeClass("edit").addClass("no_edit");
            template.find("input").val(arr[index].id);
            //标题与描述
            template.find(".title").find("div").each(function (cnt) {
                if (cnt == 0) {
                    $(this).html(arr[index].title);
                } else {
                    $(this).html(arr[index].remark);
                }
            });

            //清空原有的预置选项
            template.find(".options").empty();
            var options = arr[index].options;
            var answerArray = [];
            for (var j = 0; j < options.length; j++) {
                template.find(".options").append($('<div class="no_edit" contenteditable="false">' + options[j].opt + '</div>'));
                if (options[j].answer == 1) {
                    answerArray.push(j + 1);
                }
            }
            //如果判断存在设置答案，则拼接一下
            if (answerArray.length > 0) {
                template.find(".answer").html(answerArray.join(","));
            }
            //隐藏按钮
            template.find('.mysave').hide();
            template.find('.mysaveitem').hide();
            template.find('.myedit').show();
            $('.content').append(template);
        }


        function loadText(type, arr, index) {
            let template;
            if (type == 3) {
                template = $($('.inputTemplate').html());
            } else if (type == 4) {
                template = $($('.textTemplate').html());
            }
            //设置为div为非编辑状态
            template.find("div .edit").prop("contenteditable", false);
            template.removeClass("using");
            template.find("div .edit").removeClass("edit").addClass("no_edit");
            template.find("input").val(arr[index].id);
            //标题与描述
            template.find(".title").find("div").each(function (cnt) {
                if (cnt == 0) {
                    $(this).html(arr[index].title);
                } else {
                    $(this).html(arr[index].remark);
                }
            });
            template.find('.result').find("div").each(function (cnt) {
                if (cnt == 0) {
                    $(this).html(arr[index].result.result);
                }
            })
            //隐藏按钮
            template.find('.mysave').hide();
            template.find('.mysaveitem').hide();
            template.find('.myedit').show();
            $('.content').append(template);
        }

        function save(obj) {
            var question = {};
            var mores = {};
            if (obj.hasClass("radio")) {
                question.type = 1;
            } else if (obj.hasClass("checkbox")) {
                question.type = 2;
            } else if (obj.hasClass("inputx")) {
                question.type = 3;
            } else {
                question.type = 4;
            }
            //title+remark
            obj.find('.title').find('div').each(function (index) {
                if (index == 0) {
                    question.title = $(this).html();
                }
                if (index == 1) {
                    question.remark = $(this).html();
                }
            });
            var _answer = "";
            var _result = "";

            question.score = obj.find('.required').find('.scorevalue').html();
            _answer = obj.find('.required').find('.answer').html();
            _result = obj.find(".result").find('.resultAnswer').html();
            console.log(_result);

            if (question.type == 1 || question.type == 2) {
                //选项
                var arr = [];
                var anArray = _answer.split(",");
                obj.find('.options').find('div').each(function (index) {
                    var option = {};
                    option.opt = $(this).html();
                    option.type = question.type;
                    for (var i = 0; i < anArray.length; i++) {
                        if (anArray[i] == (index + 1)) {
                            option.answer = 1;
                        }
                    }
                    arr.push(option);
                });
                question.options = arr;
            } else if (question.type == 3) {
                var questionResult = {};
                questionResult.type = question.type;

                questionResult.result = _result;
                question.result = questionResult;
            } /*else if (question.type == 4) {
                var arr = {};
                obj.find('.mores').find('.more').find('div').each(function (index) {
                    var questionMore = {};
                    questionMore.title=$('#questionMoreTitle').html();
                    questionMore.result=
                })

            }*/
            question.examId = ${exam.id};
            if (obj.find('input').val()) {
                question.id = obj.find('input').val()
            }
            console.log(question);
            $.ajax({
                url: "../question/create",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(question),
                dataType: 'json',
                success: function (data) {
                    console.log(data.id);
                    obj.find('input').val(data.id);
                    location.reload();
                }
            })

        }


        //新增选项操作
        $(".content").on('click', '.mysaveitem', function () {
            var obj = $(this).parents(".using");
            obj.find(".options").append($('<div class="edit" contenteditable="true">选项</div>'));
        }); //新增选项操作
/*        $(".content").on('click', '.mysaveitem2', function () {
            var obj = $(this).parents(".using");
            obj.find(".mores").append($('<div class="edit" name="questionMoreTitle" contenteditable="true">小题标题</div>' +
                '<div class="edit" name="questionMoreResult" contenteditable="true">小题答案</div><br>'));
        });*/
        //双击删除选项操作
        $(".content").on('dblclick', '.edit', function () {
            $(this).remove();
        });


        //编辑操作
        $(".content").on('click', '.myedit', function () {
            if (isEditing()) {
                layer.msg("正在编辑，请先保存");
                return;
            }
            var obj = $(this).parent().parent().addClass('using');
            obj.find(".no_edit").prop("contenteditable", true);
            obj.find(".no_edit").removeClass("no_edit").addClass("edit");
            //隐藏
            obj.find('.mysave').show();
            obj.find('.mysaveitem').show();
            obj.find('.myedit').hide();
        });

        //是否必填项
        $(".content").on('click', '.layui-form-checkbox', function () {
            //判断当前是否可编辑，如果不可编辑，则不可点击
            var flag = $(this).parent().parent().hasClass("using");
            if (flag) {
                if ($(this).hasClass("layui-form-checked")) {
                    $(this).removeClass("layui-form-checked")
                } else {
                    $(this).addClass("layui-form-checked")
                }
            } else {
                layer.msg("请切换编辑状态");
            }
        });

        //统计分值
        $(".content").on('click', '.checkscore', function () {
            var flag = $(this).parent().parent().hasClass("using");
            if (flag) {
                if ($(this).hasClass("layui-form-checked")) {
                    $(this).addClass("layui-form-checked")
                    $(this).siblings('.scorevalue').show();
                    $(this).siblings('.answer').show();
                } else {
                    $(this).removeClass("layui-form-checked")
                    $(this).siblings('.scorevalue').hide();
                    $(this).siblings('.answer').hide();
                }
            } else {
                layer.msg("请切换编辑状态");
            }
        });

        function loadTemplation(type) {
            switch (type) {
                case "radio_type":
                    return $('.radioTemplate').html();
                case "checkbox_type":
                    return $('.checkboxTemplate').html();
                case "input_type":
                    return $('.inputTemplate').html();
              /*  case "text_type":
                    return $('.textTemplate').html();*/
            }
        }
    });
</script>
</body>
</html>