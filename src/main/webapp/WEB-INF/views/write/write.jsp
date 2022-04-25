<jsp:include page="../common/header.jsp"></jsp:include>

<!-- Preloader -->
<div class="cover"></div>

<div class="header">
    <div class="container">
        <div class="logo">
            <a href="index.html">
                <img src="img/logo.png" alt="Logo">
            </a>
        </div>

        <!-- Menu Hamburger (Default) -->
        <button class="main-menu-indicator" id="open-button">
            <span class="line"></span>
        </button>
        <jsp:include page="../common/right-sidebar.jsp"></jsp:include>
        <!-- End of Menu Hamburger (Default) -->

    </div>
</div>



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
    .filepond--panel-center .filepond--panel-root{ transform: none; }
</style>
<script>
    FilePond.registerPlugin(

        FilePondPluginImagePreview,
        FilePondPluginImageResize,
        FilePondPluginImageTransform

    );

    const inputElement = document.querySelector("input[type='file']");

    const pond = FilePond.create(inputElement, {

        //imageResizeTargetWidth: 256,

        // callback when the image is added
        onaddfile:(err, fileItem)=>{
            console.log(err, fileItem.getMetadata('resize'));
        }

    });

</script>

<jsp:include page="../common/footer.jsp"></jsp:include>