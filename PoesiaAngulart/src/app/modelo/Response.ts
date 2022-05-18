import {Estudiante} from './Estudiante';
export interface Response{
  error: boolean;
  message: string;
  estudiante: Estudiante;
  estudiantes: Array<Estudiante>;
}