/* =========================================================
   ⚙️ SCRIPT GLOBAL - ARREGLAGO
   Ubicación: src/main/resources/static/js/script.js
   ========================================================= */

// Esperar a que el DOM esté listo
document.addEventListener("DOMContentLoaded", () => {
    console.log("✅ ArreglaGo UI cargado correctamente.");

    // 🔹 Navbar con efecto sticky al hacer scroll
    const navbar = document.querySelector(".navbar");
    if (navbar) {
        window.addEventListener("scroll", () => {
            if (window.scrollY > 50) {
                navbar.classList.add("navbar-scrolled", "shadow-sm");
            } else {
                navbar.classList.remove("navbar-scrolled", "shadow-sm");
            }
        });
    }

    // 🔹 Botón "Subir al inicio" (Scroll to top)
    const scrollBtn = document.createElement("button");
    scrollBtn.innerHTML = '<i class="bi bi-arrow-up-short"></i>';
    scrollBtn.classList.add("scroll-top-btn", "btn", "btn-custom");
    document.body.appendChild(scrollBtn);

    scrollBtn.style.display = "none";
    scrollBtn.style.position = "fixed";
    scrollBtn.style.bottom = "25px";
    scrollBtn.style.right = "25px";
    scrollBtn.style.zIndex = "1000";
    scrollBtn.style.borderRadius = "50%";
    scrollBtn.style.width = "45px";
    scrollBtn.style.height = "45px";
    scrollBtn.style.fontSize = "1.5rem";
    scrollBtn.style.padding = "0";

    window.addEventListener("scroll", () => {
        scrollBtn.style.display = window.scrollY > 300 ? "block" : "none";
    });

    scrollBtn.addEventListener("click", () => {
        window.scrollTo({ top: 0, behavior: "smooth" });
    });

    // 🔹 Animaciones suaves para enlaces internos (anclas)
    const smoothLinks = document.querySelectorAll('a[href^="#"]');
    smoothLinks.forEach(link => {
        link.addEventListener("click", e => {
            e.preventDefault();
            const targetId = link.getAttribute("href");
            const target = document.querySelector(targetId);
            if (target) {
                window.scrollTo({
                    top: target.offsetTop - 80,
                    behavior: "smooth"
                });
            }
        });
    });

    // 🔹 Cierre automático del menú móvil al seleccionar opción
    const navLinks = document.querySelectorAll(".navbar-nav .nav-link");
    const navCollapse = document.querySelector(".navbar-collapse");
    if (navLinks && navCollapse) {
        navLinks.forEach(link => {
            link.addEventListener("click", () => {
                const bsCollapse = new bootstrap.Collapse(navCollapse, { toggle: false });
                bsCollapse.hide();
            });
        });
    }

    // 🔹 Fade-in para secciones al hacer scroll
    const faders = document.querySelectorAll(".fade-in-section");

    const appearOptions = {
        threshold: 0.2,
        rootMargin: "0px 0px -50px 0px"
    };

    const appearOnScroll = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (!entry.isIntersecting) return;
            entry.target.classList.add("visible");
            observer.unobserve(entry.target);
        });
    }, appearOptions);

    faders.forEach(fader => appearOnScroll.observe(fader));

    // 🔹 Mensaje de bienvenida (solo la primera vez)
    if (!sessionStorage.getItem("arreglagoVisited")) {
        console.log("👋 Bienvenido a ArreglaGo!");
        sessionStorage.setItem("arreglagoVisited", "true");
    }

    
    /* =========================================================
       🎠 CARRUSEL HERO AUTOMÁTICO
       ========================================================= */
    const heroCarousel = document.querySelector("#heroCarousel");
    if (heroCarousel) {
        new bootstrap.Carousel(heroCarousel, {
            interval: 4000, // cambia cada 4 segundos
            ride: "carousel",
            pause: false,
            wrap: true
        });
    }
});
