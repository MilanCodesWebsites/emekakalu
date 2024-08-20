document.addEventListener("DOMContentLoaded", () => {
    const galleryItems = document.querySelectorAll(".gallery-item img");
    const carouselModal = document.getElementById("carouselModal");
    const carouselImage = document.getElementById("carouselImage");
    const closeBtn = document.querySelector(".close-btn");
    const prevBtn = document.getElementById("prevBtn");
    const nextBtn = document.getElementById("nextBtn");

    let currentIndex = 0;

    galleryItems.forEach((item, index) => {
        item.addEventListener("click", () => {
            currentIndex = index;
            openCarousel(item.src);
        });
    });

    // Close the carousel if clicking outside the image or on the close button
    carouselModal.addEventListener("click", (event) => {
        if (event.target === carouselModal || event.target === closeBtn) {
            closeCarousel();
        }
    });

    prevBtn.addEventListener("click", showPrevImage);
    nextBtn.addEventListener("click", showNextImage);

    function openCarousel(src) {
        carouselModal.style.display = "flex";
        carouselImage.src = src;
    }

    function closeCarousel() {
        carouselModal.style.display = "none";
    }

    function showPrevImage() {
        currentIndex = (currentIndex - 1 + galleryItems.length) % galleryItems.length;
        carouselImage.src = galleryItems[currentIndex].src;
    }

    function showNextImage() {
        currentIndex = (currentIndex + 1) % galleryItems.length;
        carouselImage.src = galleryItems[currentIndex].src;
    }
});
