<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>搜索CSA</title>

    <%@include file="WEB-INF/jsp/common/head.jsp" %> <!--静态包含产生一个service，动态的话会产生多个-->
    <style>


        .vertical-center {
            padding: 10px;
        }

        .casImg {
            width: 100%;
        }


    </style>
</head>
<body>
<div class="container">
    <div id="navbarExample" class="navbar navbar-static">
        <div class="navbar-inner">
            <div class="input-group vertical-center">
                <input type="text" id="search_keyword" placeholder="CAS No.,Product Name,Formula"
                       class="form-control input-lg">
                <span class="input-group-addon btn btn-primary" id="search_btn"> <span
                        class="glyphicon glyphicon-search"></span>SEARCH</span>
            </div>
        </div>
    </div>
    <div>
        <ul id="casList" class="list-group">

        </ul>


    </div>
    <!--弹出层-->
    <div id="contactModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="contactTitle">

        <div class="modal-dialog modal-sm" role="document">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title text-left" id="contactTitle"></h4>
                </div>

                <div class="modal-body">
                    <form class="contactForm">
                        <div class="form-group">
                            <label for="casno" class="control-label"><span class="glyphicon glyphicon-tag"></span>CasNo:</label>
                            <input type="text" class="form-control" readonly="readonly" id="casno">
                        </div>
                        <div class="form-group">
                            <label for="name" class="control-label"><span class="glyphicon glyphicon-user"></span>Name*:</label>
                            <input type="text" class="form-control" id="cname" name="cname">
                        </div>
                        <div class="form-group">
                            <label for="country" class="control-label"><span class="glyphicon glyphicon-flag"></span>Country:</label>
                            <input type="text" class="form-control" id="country" name="country">
                        </div>
                        <div class="form-group">
                            <label for="city" class="control-label"><span class="glyphicon glyphicon-home"></span>City:</label>
                            <input type="text" class="form-control" id="city" name="city">
                        </div>
                        <div class="form-group">
                            <label for="mobile" class="control-label"><span class="glyphicon glyphicon-phone"></span>Mobile*:</label>
                            <input type="tel" class="form-control" id="mobile" name="mobile">
                        </div>
                        <div class="form-group">
                            <label for="email" class="control-label"><span class="glyphicon glyphicon-envelope"></span>E-mail*:</label>
                            <input type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="control-label"><span
                                    class="glyphicon glyphicon-comment"></span>Message*:</label>
                            <textarea class="form-control" id="message-text" id="message" name="message"></textarea>
                        </div>
                        <div class="form-group">
                            <h4>We will reply you ASAP!!</h4>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <%--验证信息--%>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span
                            class="glyphicon glyphicon-remove"></span>Close
                    </button>
                    <button type="submit" class="btn btn-success" id="submit-btn">
                        <span class="glyphicon glyphicon-envelope"></span>
                        Submit
                    </button>
                </div>

            </div>
        </div>
    </div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<link href="http://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
<script type="text/javascript">
    var pageNO = 1;

    $(function () {
        $("#search_btn").click(function () {
            var search_keyword = $("#search_keyword").val();
            var cat_list = $("#casList");
            pageNO = 1
            $.ajax({
                url: '/cas/findCas',
                type: 'GET',
                data: {
                    searchArgs: search_keyword,
                    pageNo : pageNO
                },
                success: function (data) {
                    var str = '';
                    cat_list.empty();

                    if (data['status']==1) {
                        var list = data['content'];
                        for (var i = 0; i < list.length ; i++) {
                            str += '<li class="list-group-item">';
                            for (var key in list[i]) {
                                if (key != "casUrl") {
                                    if (key == "casNO") {
                                        str += '<img class="casImg" src="/casimg/' + list[i][key] + '.png" />'

                                    }
                                    str += '<p class="text-left"><span class="text-uppercase"> ' + key + ':</span><strong>' + list[i][key].replace("View More", "") + '</strong></p>';
                                }
                            }
                            str += '<button type="button" class="btn btn-primary btn-sm" data-casno=' + list[i]['casNO'] + ' data-casname=' + list[i]['casName'] + ' data-toggle="modal" data-target="#contactModal"><span class="glyphicon glyphicon-envelope"></span> Contact us!</button></li>';
                        }
                        str += '<li class="list-group-item viewmore text-center" onclick="viewmore(this)" ><span class="glyphicon glyphicon-arrow-down"></span>View more</li>'
                    } else {
                        str = '<li><h2 class="text-center">not thing!</h2></li>';
                    }
                    cat_list.append(str);
                },
                error: function (xhr) {
                    console.log('错误');
                }
            })
        })


        $('#contactModal').on('show.bs.modal', function (event) {
            $('#casno').focus();
            var button = $(event.relatedTarget);
            var casNO = button.data('casno');
            var casName = button.data('casname');
            var modal = $(this)
            modal.find('.modal-title').text(casName);
            modal.find('.modal-body #casno').val(casNO);

            $("#submit-btn").click(function () {
                modal.modal('hide');
            })
        })

        $('.contactForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                cname: {
                    validators: {
                        notEmpty: {
                            message: 'name is not empty!'
                        }
                    }
                },
                mobile: {
                    validators: {
                        notEmpty: {
                            message: 'mobile is not empty!'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'e-mail is not empty!'
                        }
                    }
                },
                message: {
                    validators: {
                        notEmpty: {
                            message: 'message is not empty!'
                        }
                    }
                }
            }
        });


    })

    function viewmore(e) {
        var search_keyword = $("#search_keyword").val();
        var cat_list = $("#casList");
        var viewmore = $(e)
        console.log(viewmore)
        pageNO = pageNO+1;
        $.ajax({
            url: '/cas/findCas',
            type: 'GET',
            data: {
                searchArgs: search_keyword,
                pageNo : pageNO
            },
            success: function (data) {
                var str = '';
                if (data['status']==1) {
                    var list = data['content'];
                    for (var i = 0; i < list.length ; i++) {
                        str += '<li class="list-group-item">';
                        for (var key in list[i]) {
                            if (key != "casUrl") {
                                if (key == "casNO") {
                                    str += '<img class="casImg" src="/casimg/' + list[i][key] + '.png" />'

                                }
                                str += '<p class="text-left"><span class="text-uppercase">' + key + ':</span><strong>' + list[i][key].replace("View More", "") + '</strong></p>';
                            }
                        }
                        str += '<button type="button" class="btn btn-primary btn-sm" data-casno=' + list[i]['casNO'] + ' data-casname=' + list[i]['casName'] + ' data-toggle="modal" data-target="#contactModal"><span class="glyphicon glyphicon-envelope"></span> Contact us!</button></li>';
                    }
                    str += '<li class="list-group-item viewmore text-center" onclick="viewmore(this)" ><span class="glyphicon glyphicon-arrow-down"></span>View more</li>'
                } else {
                    str = '<li><h2 class="text-center">not thing!</h2></li>';
                }
                viewmore.remove();
                cat_list.append(str);

            },
            error: function (xhr) {
                console.log('错误');
            }
        })
    }



</script>
</html>
