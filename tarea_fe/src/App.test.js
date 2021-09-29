import { render, screen } from '@testing-library/react';
import App from './App';

test('Render Titulo', () => {
  render(<App />);
  const linkElement = screen.getByText(/Mantenedor de Tareas/i);
  expect(linkElement).toBeInTheDocument();
});
