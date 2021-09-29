import { useEffect,useState } from "react"
import './App.css';
import AgregarTarea from './AgregarTarea';
import ListarTareas from './ListarTareas';

function App() {

  const [tarea, setTarea] = useState({
    id:0,
    descripcion:"",
    fechaCreacion:"",
    vigente:1
  })

  const [tareas, setTareas] = useState([])

  const [tareasActualizada, setTareasActualizada] = useState(false)

  useEffect(() => {
    fetch("http://localhost:8088/tareas")
    .then(rs => rs.json())
    .then(data => setTareas(data))
    setTareasActualizada(false)
}, [tareasActualizada])


  return (
    <div className="container-fluid">
        <div className="card">
      <div className="card-body">
      <h1 className="card-title">Mantenedor de Tareas</h1>
      <div className="row">
        <div className="col-6">
        <AgregarTarea tarea={tarea} setTarea={setTarea} ></AgregarTarea>
        </div>
      </div>
      <br></br>
      <div className="row">
        <div className="col-6">
          <ListarTareas tarea={tarea} setTareas={setTareas} tareas={tareas} setTareasActualizada={setTareasActualizada}></ListarTareas>
        </div>
      </div>
      </div>
    </div>
    </div>
  );
}

export default App
