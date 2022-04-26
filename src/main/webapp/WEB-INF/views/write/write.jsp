<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container">
    <div class="contact-map" id="map">

        <input type="file" />
    </div>

    <div class="col-md-6 col-md-offset-6 col-sm-6 col-sm-offset-6 hidden-xs">
        <div class="row">
            <div class="inner-map">
                <div class="inner-map-content">
                    <h1>Contact</h1>
                    <hr>
                    <p>Everything created in simple way</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container margin-top">
    <div class="contact-wrapper">
        <div class="row">
            <div class="col-md-3">
                <div class="contact-info">
                    <span class="icon-info">
                    <i class="pe-7s-phone"></i>
                </span>
                    <span class="title-info">CALL US:</span>
                    <span class="description-info">+001 123 222</span>
                </div>

                <div class="contact-info">
                    <span class="icon-info">
                    <i class="pe-7s-map-marker"></i>
                </span>
                    <span class="title-info">ADDRESS:</span>
                    <span class="description-info">Street 23, CITY p.n 300 Canada</span>
                </div>

                <div class="contact-info">
                    <span class="icon-info">
                    <i class="pe-7s-mail"></i>
                </span>
                    <span class="title-info">EMAIL:</span>
                    <span class="description-info">info@gmail.com</span>
                </div>
            </div>

            <form method="GET">
                <div class="contact-form">

                    <div class="col-md-4">
                        <input type="text" placeholder="NAME *">
                        <input type="text" placeholder="E-MAIL *">
                        <input type="text" placeholder="SUBJECT">
                    </div>
                    <div class="col-md-5">
                        <textarea placeholder="MESSAGE"></textarea>
                        <input type="submit" value="SEND">
                    </div>
                </div>
            </form>
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

</script>

<jsp:include page="../common/footer.jsp"></jsp:include>