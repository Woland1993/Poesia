import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ApiService } from '../api.service';
import {Estudiante} from '../modelo/Estudiante';
import {Response} from '../modelo/Response'
import {MatDialog} from '@angular/material/dialog';


@Component({
  selector: 'app-componete',
  templateUrl: './componete.component.html',
  styleUrls: ['./componete.component.css']
})
export class ComponeteComponent {
  addressForm = this.fb.group({
    carnet: [null, Validators.required],
    nombre: [null, Validators.required],
    segundo_nombre: [null, Validators.required],
    apellido: [null, Validators.required],
    segundo_apellido: [null, Validators.required],
    telefono: [null, Validators.required],
    fecha_nacimiento: [null, Validators.required],
    carrera: [null, Validators.required],
    genero_poesia: [null, Validators.required],
    genero: [null, Validators.required]
  });

  hasUnitNumber = false;

  genero_poesia = [
    {name: 'lirica', abbreviation: 'lirica'},
    {name: 'epica', abbreviation: 'epica'},
    {name: 'dramatica', abbreviation: 'dramatica'}
  ];

  constructor(private fb: FormBuilder,
    private api: ApiService,public dialog: MatDialog) {}

  async onSubmit(form:Estudiante) {
   console.log(this.addressForm.value);
   this.api.crearAlumno(form).subscribe(data =>{
     console.log(data);
     const dialogRef = this.dialog.open(DialogContentExampleDialog);
     dialogRef.afterClosed().subscribe(result => {
       console.log(`Dialog result: ${result}`);
     });
    }
   );
  }
 
}

@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: 'dialog-content-example-dialog.html',
})
export class DialogContentExampleDialog {


}

