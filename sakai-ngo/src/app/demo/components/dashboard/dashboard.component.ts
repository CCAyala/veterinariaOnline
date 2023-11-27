import { Component, OnInit, OnDestroy } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Product } from '../../api/product';
import { ProductService } from '../../service/product.service';
import { Subscription } from 'rxjs';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { Button } from 'primeng/button';
<<<<<<< HEAD
import { Carrusel } from '../../api/carrusel';

@Component({
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard-component.scss']
=======
import { AuthService } from '@auth0/auth0-angular';

@Component({
    templateUrl: './dashboard.component.html',
    
>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c
})
export class DashboardComponent implements OnInit, OnDestroy {

    
    items!: MenuItem[];

    images: any[] | undefined;
    products!: Product[];

    carrusel !: Carrusel[];
    chartData: any;
    
    responsiveOptions: any[];
    chartOptions: any;

    subscription!: Subscription;

    constructor(private productService: ProductService, public layoutService: LayoutService,public auth: AuthService) {
        this.subscription = this.layoutService.configUpdate$.subscribe(() => {
            this.initChart();
        });
    }

    ngOnInit() {
        this.initChart();
<<<<<<< HEAD
    // Puedes cargar dinámicamente las imágenes aquí si es necesario
    this.images = [
       
        { source: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-25 a las 16.00.24_f8db9d0a.jpg', thumbnailImageSrc: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-09 a las 14.36.29_74a353d6.jpg', alt: 'Descripción de la imagen 2' },
        { source: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-25.jpg', thumbnailImageSrc: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-09 a las 14.36.29_74a353d6.jpg', alt: 'Descripción de la imagen 2' },
        { source: 'assets/demo/images/galleria/images.jpeg', thumbnailImageSrc: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-09 a las 14.36.29_74a353d6.jpg', alt: 'Descripción de la imagen 2' },
        { source: 'assets/demo/images/galleria/images.jpeg', thumbnailImageSrc: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-09 a las 14.36.29_74a353d6.jpg', alt: 'Descripción de la imagen 2' },

        { source: 'assets/demo/images/galleria/descarga.jpeg', thumbnailImageSrc: 'assets/demo/images/galleria/perro.jpg', alt: 'Descripción de la imagen 2' },
=======
        this.productService.getProductsSmall().then(data => this.products = data);
        
        this.items = [
            { label: 'Add New', icon: 'pi pi-fw pi-plus' },
            { label: 'Remove', icon: 'pi pi-fw pi-minus' }
        ];
>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c

        { source: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-25 a las 16.00.23_629a7511.jpg', thumbnailImageSrc: 'assets/demo/images/galleria/Imagen de WhatsApp 2023-10-25 a las 16.00.23_629a7511 (1).jpg', alt: 'Descripción de la imagen 1' },
       
        // Agrega más imágenes según sea necesario
      ];

<<<<<<< HEAD


     
=======
        this.responsiveOptions = [
            {
                breakpoint: '1024px',
                numVisible: 3,
                numScroll: 3
            },
            {
                breakpoint: '768px',
                numVisible: 2,
                numScroll: 2
            },
            {
                breakpoint: '560px',
                numVisible: 1,
                numScroll: 1
            }
        ];

>>>>>>> 092996c1c9e6c2b625989842b5dea6a44d96505c
    }

    initChart() {
        const documentStyle = getComputedStyle(document.documentElement);
        const textColor = documentStyle.getPropertyValue('--text-color');
        const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
        const surfaceBorder = documentStyle.getPropertyValue('--surface-border');

        this.chartData = {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [
                {
                    label: 'First Dataset',
                    data: [65, 59, 80, 81, 56, 55, 40],
                    fill: false,
                    backgroundColor: documentStyle.getPropertyValue('--bluegray-700'),
                    borderColor: documentStyle.getPropertyValue('--bluegray-700'),
                    tension: .4
                },
                {
                    label: 'Second Dataset',
                    data: [28, 48, 40, 19, 86, 27, 90],
                    fill: false,
                    backgroundColor: documentStyle.getPropertyValue('--green-600'),
                    borderColor: documentStyle.getPropertyValue('--green-600'),
                    tension: .4
                }
            ]
        };

        this.chartOptions = {
            plugins: {
                legend: {
                    labels: {
                        color: textColor
                    }
                }
            },
            scales: {
                x: {
                    ticks: {
                        color: textColorSecondary
                    },
                    grid: {
                        color: surfaceBorder,
                        drawBorder: false
                    }
                },
                y: {
                    ticks: {
                        color: textColorSecondary
                    },
                    grid: {
                        color: surfaceBorder,
                        drawBorder: false
                    }
                }
            }
        };
    }

    ngOnDestroy() {
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }


}
