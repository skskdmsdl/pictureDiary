<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container">
    <form id="writeForm" method="post" enctype="multipart/form-data" action="/write/writeDiary.do">
	    <div class="diary-image" id="diary-image">
	        <input type="file" name="file" />
	    </div>
	
	    <div class="col-md-6 col-md-offset-6 col-sm-6 col-sm-offset-6 hidden-xs">
	        <div class="row">
	            <div class="inner-diary">
	                <div class="inner-diary-content">
	                    <span class="tui-datepicker-input tui-datetime-input tui-has-focus">
					        <input type="text" id="datepicker-input" aria-label="Date-Time" name="diaryDate">
					        <span class="tui-ico-date"></span>
					    </span>
						<div id="tui-datepicker" style="margin-top: -1px;"></div>
					    <input type="text" id="title-info" placeholder="TITLE" name="title">
			                <div class="diary-content-form">
			                    <textarea placeholder="CONTENT" name="content"></textarea>
 			                    <input type="submit" class='submit' value="SAVE"> 
			                </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</form>
</div>

<style>
    .filepond--credits{ display: none; }
    .filepond--item{ height: 389px !important; }

</style>
<script>
// initialize the plugins
FilePond.registerPlugin(
    FilePondPluginImagePreview
);

const inputElement = document.querySelector("input[type='file']");
const pond = FilePond.create
			(inputElement, {
				storeAsFile: true,
			});

// toast UI
$(document).ready(function () {
    var datepicker = new tui.DatePicker('#tui-datepicker',
        {
        language: 'en',
        date: new Date(),
        input: {
            element: '#datepicker-input',
            format: 'yyyy-MM-dd'
        }
    });
});

// controller 메시지
const message = '${diaryMsg}';
if(message != ""){
	Swal.fire({
		text: message,
		confirmButtonColor: '#12B886'
	});
};

// save 버튼 클릭 시
$(".submit").click(function(e) {
	e.preventDefault();
	const title = $('[name=title]').val();
	if(title == ''){
		Swal.fire({
			text: '제목을 입력해주세요.',
			confirmButtonColor: '#12B886'
		});
		return;
	}
	$('#writeForm').submit();
});
</script>

<jsp:include page="../common/footer.jsp"></jsp:include>