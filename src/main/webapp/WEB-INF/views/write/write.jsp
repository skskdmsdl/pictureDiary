<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container">
    <div class="diary-image" id="diary-image">
        <input type="file" />
    </div>

    <div class="col-md-6 col-md-offset-6 col-sm-6 col-sm-offset-6 hidden-xs">
        <div class="row">
            <div class="inner-diary">
                <div class="inner-diary-content">
                    <span class="tui-datepicker-input tui-datetime-input tui-has-focus">
				        <input type="text" id="datepicker-input" aria-label="Date-Time">
				        <span class="tui-ico-date"></span>
				    </span>
				    <div id="tui-datepicker" style="margin-top: -1px;"></div>
					<br />
                    <form method="GET">
		                <div class="diary-content-form">
		                    <textarea placeholder="CONTENT"></textarea>
		                    <input type="submit" value="SAVE">
		                </div>
		            </form>
                </div>
            </div>
        </div>
    </div>
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
    const pond = FilePond.create(inputElement);

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

</script>

<jsp:include page="../common/footer.jsp"></jsp:include>