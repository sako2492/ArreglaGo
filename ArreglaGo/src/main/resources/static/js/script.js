/* =========================================================
   ⚙️ SCRIPT GLOBAL - ARREGLAGO
   Ubicación: src/main/resources/static/js/script.js
   ========================================================= */

// =========================================================
// ❌ FUNCIÓN DE VALIDACIÓN GLOBAL (DEBE ESTAR FUERA DEL DOMContentLoaded) ❌
// =========================================================
function validateHeroSearch() {
    // 1. Obtener el valor del campo de búsqueda
    const input = document.getElementById('heroSearchInput');
    
    // Si por alguna razón el elemento no existe, permitimos el envío para evitar fallos
    if (!input) {
        return true; 
    }

    const query = input.value.trim();

    // 2. Verificar si está vacío
    if (query === "") {
        // Mostrar un mensaje de advertencia
        alert("❌ Por favor, ingresa el servicio o profesional que necesitas buscar.");
        
        // Enfocar el campo para que el usuario pueda escribir
        input.focus(); 
        
        // Retorna false para PREVENIR que el formulario se envíe.
        return false; 
    }

    // 3. Si no está vacío, permite que el formulario se envíe
    return true;
}


// =========================================================
// ✅ SCRIPT PRINCIPAL (USAR document.addEventListener)
// =========================================================   
// Esperar a que el DOM esté listo
document.addEventListener("DOMContentLoaded", () => {
    console.log("✅ ArreglaGo UI cargado correctamente.");

     /* =========================================================
       🔧 AJUSTE DINÁMICO DEL PADDING-TOP DEL BODY
       (Evita que el navbar fijo tape el contenido)
       ========================================================= */
    function ajustarPaddingBody() {
        const nav = document.querySelector(".navbar.fixed-top") || document.querySelector(".navbar");
        if (!nav) return;

        const altura = nav.getBoundingClientRect().height;
        document.body.style.paddingTop = altura + "px";
    }

    // Ejecutar al inicio y cada vez que cambie el tamaño de pantalla
    ajustarPaddingBody();
    window.addEventListener("resize", ajustarPaddingBody);

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

    // Este script debe estar en tu script.js para que needs-validation funcione.
    const forms = document.querySelectorAll('.needs-validation');
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) { // Si Bootstrap encuentra un campo required vacío
                event.preventDefault(); // Detiene el envío
                event.stopPropagation();
            }
            form.classList.add('was-validated'); 
        }, false);
    });

});
