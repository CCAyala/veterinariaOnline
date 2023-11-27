import { ChangeDetectorRef, Component, ViewChild, signal, OnInit } from '@angular/core';
import { CalendarOptions, DateSelectArg, EventClickArg, EventApi  } from '@fullcalendar/core';
import interactionPlugin from '@fullcalendar/interaction';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import listPlugin from '@fullcalendar/list';
import { DialogService } from 'primeng/dynamicdialog';
import { INITIAL_EVENTS, createEventId } from './event-utils';
import { Dialog } from 'primeng/dialog';
import { FullCalendarComponent } from '@fullcalendar/angular';
import { CitaMedicaService } from '../../service/cita-medica.service';


@Component({
  selector: 'app-cita-medica',
  templateUrl: './cita-medica.component.html',
  styleUrls: ['./cita-medica.component.scss']
})
export class CitaMedicaComponent implements OnInit{


 
  visible: boolean=false;
  calendarVisible = signal(true);
  calendarOptions = signal<CalendarOptions>({
    plugins: [
      interactionPlugin,
      dayGridPlugin,
      timeGridPlugin,
      listPlugin,
    ],
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    initialView: 'dayGridMonth',
    initialEvents: INITIAL_EVENTS, // alternatively, use the `events` setting to fetch from a feed
    weekends: true,
    editable: true,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
    select: this.handleDateSelect.bind(this),
    eventClick: this.handleEventClick.bind(this),
    eventsSet: this.handleEvents.bind(this)
    /* you can update a remote database when these fire:
    eventAdd:
    eventChange:
    eventRemove:
    */
  });
  currentEvents = signal<EventApi[]>([]);
  modal: any;
  handleDateClick: any;
  vacationService: any;

  constructor(private changeDetector: ChangeDetectorRef,private Dialog: DialogService,  
  private citaMedicaService:CitaMedicaService ) {
    console.log("entro al componente")
    this.citaMedicaService.listaVeterinarios("lista").subscribe(
      (P : any)=>{

        console.log(P);
      }
    )
  }
  ngOnInit(): void {
    //this.loadEvents()

    this.citaMedicaService.listaVeterinarios("lista").subscribe(
      (P : any)=>{

        console.log(P);
      }
    )
  }

  handleCalendarToggle() {
    this.calendarVisible.update((bool) => !bool);
  }

  handleWeekendsToggle() {
    this.calendarOptions.mutate((options) => {
      options.weekends = !options.weekends;
    });
  }

  handleDateSelect(selectInfo: DateSelectArg) {
    try {
      const calendarApi = selectInfo.view.calendar;
  
      if (calendarApi) {
        calendarApi.unselect(); // clear date selection
        
        // Resto del código...
      } else {
        console.error('Calendar API is null or undefined.');
      }
    } catch (error) {
      console.error('Error handling date select:', error);
  
    }
    // Abre el modal al seleccionar una fecha
    const modal = document.getElementById('citaMedicaModal');
    modal.style.display = 'block';
  
    // Lógica para cerrar el modal si es necesario (por ejemplo, al guardar la cita)
    const closeModalBtn = document.getElementById('guardarCitaBtn');
    closeModalBtn.addEventListener('click', () => {
      // Aquí deberías agregar la lógica para guardar la cita en la base de datos
      // ...
  
      // Cierra el modal después de guardar la cita
      this.modal.show();
    });
  }

  

  handleEventClick(clickInfo: EventClickArg) {
    if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
      clickInfo.event.remove();
    }
  }

  handleEvents(events: EventApi[]) {
    this.currentEvents.set(events);
    this.changeDetector.detectChanges(); // workaround for pressionChangedAfterItHasBeenCheckedError
  }


   // references the #calendar in the template
   @ViewChild('calendar') calendarComponent: FullCalendarComponent;

  calendarOption: CalendarOptions = {
    initialView: 'dayGridMonth',
    headerToolbar: { 
      left: '',
      center: 'title',
    },
    editable: true,   
  
  };

  loadEvents(): void {
      this.vacationService.getAll().subscribe((data) => {
        // My data
        console.log(data);
      })
  }
}

