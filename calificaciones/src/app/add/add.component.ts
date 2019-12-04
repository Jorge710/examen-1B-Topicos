import { Component, OnInit } from '@angular/core';
//

import { Router } from '@angular/router';
import { ConexionService } from 'src/app/services/conexion.service';



@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  item:any = {
    nombre:''
  }

  constructor(private servicio:ConexionService) { }

  ngOnInit() {
  }

  agregar(){
    this.servicio.agregarItem(this.item);
    this.item.nombre='';
  }

  

}
