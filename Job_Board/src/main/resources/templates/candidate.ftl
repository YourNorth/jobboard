<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Job Board</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!-- CSS here -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/css/magnific-popup.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/themify-icons.css">
    <link rel="stylesheet" href="/css/nice-select.css">
    <link rel="stylesheet" href="/css/flaticon.css">
    <link rel="stylesheet" href="/css/gijgo.css">
    <link rel="stylesheet" href="/css/animate.min.css">
    <link rel="stylesheet" href="/css/slicknav.css">

    <link rel="stylesheet" href="/css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid ">
                    <div class="header_bottom_border">
                        <div class="row align-items-center">
                            <div class="col-xl-3 col-lg-2">
                                <div class="logo">
                                    <a href="/index">
                                        <img src="/img/logo.png" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-7">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a href="/index">home</a></li>
                                            <li><a href="/jobs">Browse Job</a></li>
                                            <li><a href="#">pages <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                    <li><a href="/candidate">Candidates </a></li>
                                                    <li><a href="/elements">elements</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#">blog <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                    <li><a href="/blog">blog</a></li>
                                                    <li><a href="/single_blog">single-blog</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="/contact">Contact</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                                <div class="Appointment">
                                    <div class="phone_num d-none d-xl-block">
                                        <a href="/my_profile">My profile</a>
                                    </div>
                                    <div class="d-none d-lg-block">
                                        <a class="boxed-btn3" href="/create_profile">Create profile</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->

    <!-- bradcam_area  -->
    <div class="bradcam_area bradcam_bg_1">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text">
                        <h3>Candidates</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->

    <!-- catagory_area -->
    <form action="/candidates" method="post" id="form2">
    <div class="catagory_area">
        <div class="container">
            <div class="row cat_search">
                <div class="col-lg-3 col-md-4">
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="firstName" name="firstName" placeholder="First name">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <select id="city" name="city" class="wide" >
                            <option data-display="City">City</option>
                            <#list cities as city>
                                <option value="${city.name}">${city.name}</option>
                            </#list>
                        </select>
                    </div>
                    <p></p>
                    <div class="input-group">
                        <select id="country" name="country" class="wide" >
                            <option data-display="Country">Country</option>
                            <#list countries as country>
                                <option value="${country.name}">${country.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4">
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="lastName" name="lastName" placeholder="Last name">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <select id="skill" name="skill" class="wide" >
                            <option data-display="Skill">Skill</option>
                            <#list skills as skill>
                                <option value="${skill.name}">${skill.name}</option>
                            </#list>
                        </select>
                    </div>
                    <p></p>
                    <div class="input-group">
                        <select id="native_language" name="native_language" class="wide" >
                            <option data-display="Language">Language</option>
                            <#list languages as language>
                                <option value="${language.name}">${language.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4">
                    <div class="input-group">
                        <select id="gender" name="gender" class="wide" >
                            <option data-display="Gender">Gender</option>
                            <#list genders as gender>
                                <option value="${gender}">${gender}</option>
                            </#list>
                        </select>
                    </div>
                    <p></p>
                    <div class="input-group">
                        <select id="education" name="education" class="wide" >
                            <option data-display="Education">Education</option>
                            <#list educations as education>
                                <option value="${education.name}">${education.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="col-lg-3 col-md-12">
                    <div class="reset_btn">
                        <button  class="boxed-btn3 w-100" type="submit" onclick="return validateForm()">Find candidate</button>
                    </div>
                    <p></p>
                    <form action="/candidates" method="get" id="form3">
                    <div class="job_btn">
                        <button  class="boxed-btn3 w-100" type="submit" onclick="return validateForm()">Show all</button>
                    </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="popular_search d-flex align-items-center">
                        <span>Key skills:</span>
                        <ul>
                            <li><a href="/candidates/Swift">Swift Developer</a></li>
                            <li><a href="/candidates/Go">Go Developer</a></li>
                            <li><a href="/candidates/PHP">PHP Developer</a></li>
                            <li><a href="/candidates/Python">Python Developer</a></li>
                            <li><a href="/candidates/JavaScript">JavaScript Developer</a></li>
                            <li><a href="/candidates/Rust">Rust Developer</a></li>
                            <li><a href="/candidates/Kotlin">Kotlin Developer</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
    <!--/ catagory_area -->

    <script>
        function validateForm() {
            let gender = document.getElementById('gender');
            let error = '';
            if (gender.value !== "MALE" && gender.value !== "FEMALE" && gender.value !== "NotSpecified"){
                error += 'Gender field cannot be empty! \n';
            }
            if (error !== '') {
                swal("Oops", error, "error");
                return false;
            } else {
                swal("Good job!", 'Ok', "success");
                let form = document.getElementById("form2");
                form.submit();
            }
        }
    </script>

    <!-- featured_candidates_area_start  -->
    <div class="featured_candidates_area candidate_page_padding">
        <div class="container">
            <div class="row">
                <#list candidates as candidate>
                <div class="col-md-6 col-lg-3">
                    <div class="single_candidates text-center">
                        <div class="thumb">
                            <img src="${candidate.link_img}" alt="">
                        </div>
                        <a href="/candidate/${candidate.id}"><h4>${candidate.firstName} ${candidate.lastName}</h4></a>
                        <p>${candidate.skill.name}</p>
                    </div>
                </div>
                <#else>
                    <p>No candidates</p>
                </#list>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="pagination_wrap">
                        <ul>
                            <li><a href="#"> <i class="ti-angle-left"></i> </a></li>
                            <li><a href="#"><span>01</span></a></li>
                            <li><a href="#"><span>02</span></a></li>
                            <li><a href="#"> <i class="ti-angle-right"></i> </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- featured_candidates_area_end  -->



    <!-- footer start -->
    <footer class="footer">
        <div class="footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-3 col-md-6 col-lg-3">
                        <div class="footer_widget wow fadeInUp" data-wow-duration="1s" data-wow-delay=".3s">
                            <div class="footer_logo">
                                <a href="#">
                                    <img src="/img/logo.png" alt="">
                                </a>
                            </div>
                            <p>
                                finloan@support.com <br>
                                +10 873 672 6782 <br>
                                600/D, Green road, NewYork
                            </p>
                            <div class="socail_links">
                                <ul>
                                    <li>
                                        <a href="#">
                                            <i class="ti-facebook"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-google-plus"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-instagram"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </div>
                    <div class="col-xl-2 col-md-6 col-lg-2">
                        <div class="footer_widget wow fadeInUp" data-wow-duration="1.1s" data-wow-delay=".4s">
                            <h3 class="footer_title">
                                Company
                            </h3>
                            <ul>
                                <li><a href="#">About </a></li>
                                <li><a href="#"> Pricing</a></li>
                                <li><a href="#">Carrier Tips</a></li>
                                <li><a href="#">FAQ</a></li>
                            </ul>

                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 col-lg-3">
                        <div class="footer_widget wow fadeInUp" data-wow-duration="1.2s" data-wow-delay=".5s">
                            <h3 class="footer_title">
                                Category
                            </h3>
                            <ul>
                                <li><a href="#">Design & Art</a></li>
                                <li><a href="#">Engineering</a></li>
                                <li><a href="#">Sales & Marketing</a></li>
                                <li><a href="#">Finance</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-6 col-lg-4">
                        <div class="footer_widget wow fadeInUp" data-wow-duration="1.3s" data-wow-delay=".6s">
                            <h3 class="footer_title">
                                Subscribe
                            </h3>
                            <form action="/subscribe" class="newsletter_form" id="form">
                                <input id="email" name="email" type="text" placeholder="Enter your mail">
                                <button type="submit" onclick="return validateForm1()">Subscribe</button>
                            </form>

                            <script>
                                function validateForm1() {
                                    let email = document.getElementById('email');
                                    let error = '';
                                    let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
                                    if (!email_regexp.test(email.value)) {
                                        error += 'Email is entered incorrectly! \n';
                                    }
                                    if (error !== '') {
                                        swal("Oops", error, "error");
                                        return false;
                                    } else {
                                        let form = document.getElementById("form");
                                        form.submit();
                                    }
                                }
                            </script>
                            <p class="newsletter_text">Esteem spirit temper too say adieus who direct esteem esteems
                                luckily.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copy-right_text wow fadeInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
            <div class="container">
                <div class="footer_border"></div>
                <div class="row">
                    <div class="col-xl-12">
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/ footer end  -->

    <!-- link that opens popup -->
    <!-- JS here -->
    <script src="/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/owl.carousel.min.js"></script>
    <script src="/js/isotope.pkgd.min.js"></script>
    <script src="/js/ajax-form.js"></script>
    <script src="/js/waypoints.min.js"></script>
    <script src="/js/jquery.counterup.min.js"></script>
    <script src="/js/imagesloaded.pkgd.min.js"></script>
    <script src="/js/scrollIt.js"></script>
    <script src="/js/jquery.scrollUp.min.js"></script>
    <script src="/js/wow.min.js"></script>
    <script src="/js/nice-select.min.js"></script>
    <script src="/js/jquery.slicknav.min.js"></script>
    <script src="/js/jquery.magnific-popup.min.js"></script>
    <script src="/js/plugins.js"></script>
    <script src="/js/gijgo.min.js"></script>



    <!--contact js-->
    <script src="/js/contact.js"></script>
    <script src="/js/jquery.ajaxchimp.min.js"></script>
    <script src="/js/jquery.form.js"></script>
    <script src="/js/jquery.validate.min.js"></script>
    <script src="/js/mail-script.js"></script>


    <script src="/js/main.js"></script>
</body>

</html>