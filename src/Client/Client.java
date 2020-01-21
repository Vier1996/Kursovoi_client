package Client;
import FX.*;
import FX.RDA_users.Add_U;
import FX.RDA_users.Delete_U;
import FX.RDA_users.Red_U;
import java.io.*;
import java.net.Socket;

public class Client {

    private static class Data_base {

        void Show_Organiz(BufferedWriter W, BufferedReader R) throws IOException {
            String INPUT = R.readLine();
            String[] INP_split = INPUT.split("//");
            String[] Orgz = new String[INP_split.length];
            for(int i = 0; i < INP_split.length; i++) {
                Orgz[i] = INP_split[i].split(" ")[2];
            }
            for(int i = 0; i < Orgz.length - 1; i++) {
                for(int j = i + 1; j < Orgz.length; j++) {
                    if (Orgz[i].equals(Orgz[j])) {
                        Orgz[j] += "*";
                    }
                }
            }

            BD_List_choice BDLC = new BD_List_choice(Orgz);
            BDLC.DATA = INPUT;
            while(BDLC.isDisplayable()) {

            }
            W.write("Y" + "\n");
            W.flush();
        }

        void Redaction(BufferedWriter W, BufferedReader R) throws IOException {
            String[] input = R.readLine().split("/");
            String[] Orgz = new String[input.length + 1];
            Orgz[0] = "";
            for(int i = 1; i < Orgz.length; i++) {
                Orgz[i] = input[i - 1];
            }
            Redaction r = new Redaction("red", Orgz, W);

            while(r.isDisplayable()) {

            }

        }

        void Addition(BufferedWriter W, BufferedReader R) throws IOException {
            Addition add = new Addition("addition", W);
            while(add.isDisplayable()) {

            }
        }

        void Del_Bank(BufferedWriter W, BufferedReader R, String T) throws IOException {
            String[] Input = R.readLine().split("/");
            Deleter del = new Deleter(W, Input, T);

            while(del.isDisplayable()) {

            }
        }
    }

    private static class Com_menu extends Data_base {
        // show, exit and etc
        void list(BufferedReader R, BufferedWriter W) throws IOException {
            System.out.println("T");
            String[] L = R.readLine().split("/");

            List LIST = new List(L);
            while(LIST.isDisplayable()) {

            }

            W.write("Y" + "\n");
            W.flush();
        }

        void SHOW_DB(BufferedWriter W, BufferedReader R) throws IOException {
            Show_Organiz(W, R);
        }
    }

    private static class Admin_menu extends Com_menu{
        BufferedWriter Wr;
        BufferedReader Rd;
        String login = "";
        int LoV = 1;
        int input = 0;

        void Add_new_u(BufferedWriter W, BufferedReader R) throws IOException {
            Add_U add = new Add_U(W);
            while (add.isDisplayable()) {

            }
        }

        void Red_u() throws IOException {
            Red_U red = new Red_U(Wr, Rd);
            while (red.isDisplayable()) {

            }
        }

        void Del_u() throws IOException {
            Delete_U del = new Delete_U(Rd, Wr);
            while(del.isDisplayable()) {

            }
        }

        void Adm_instr_red_user(BufferedWriter W, BufferedReader R) throws IOException {
            int Choice_ = 0;
            Admin_menu_tools Am_m_t = new Admin_menu_tools();

            while(Am_m_t.isDisplayable()) {

            }
            Choice_ = Am_m_t.Choice;
            W.write(Integer.toString(Choice_) + "\n");
            W.flush();

            switch (Choice_) {
                case 1:
                    Add_new_u(W, R);
                    break;
                case 2:
                    Red_u();
                    break;
                case 3:
                    Del_u();
                    break;
                default: break;
            }
        }

        void Adm_instr_red_Comp(BufferedWriter W, BufferedReader R) throws IOException {
            int Choice_ = 0;
            Admin_menu_tools_cmp Am_m_t_с = new Admin_menu_tools_cmp();
            while(Am_m_t_с.isDisplayable()) {

            }
            Choice_ = Am_m_t_с.choice;
            W.write(Integer.toString(Choice_) + "\n");
            W.flush();

            switch (Choice_) {
                case 1:
                    Addition(W,R);
                    break;
                case 2:
                    Redaction(W,R);
                    break;
                case 3:
                    Del_Bank(W, R, "");
                    break;
                default:
                    break;
            }
        }

        void Adm_list(BufferedReader R, BufferedWriter W) throws IOException {
            list(R,W);
        }

        void Compare() throws IOException {
            Compare c = new Compare(Rd);
            while(c.isDisplayable()) {

            }
        }

        void Emegrency() throws IOException {
            Emergency em = new Emergency(Wr);
            while(em.isDisplayable()) {

            }
            String acc = Rd.readLine();
            if(acc.equals("y"))
                System.exit(0);
        }

        void menu(BufferedWriter W, BufferedReader R, String L) throws IOException { // Main Func
            Wr = W;
            Rd = R;
            login = L;
            FX.Admin_menu AM = new FX.Admin_menu(login);
            while(AM.isDisplayable()) {

            }

            Wr.write(login + "\n");
            Wr.flush();
            String exist = Rd.readLine();

            if (exist.equals("exist")) {
                input = AM.input;
                Wr.write(Integer.toString(input) + "\n");
                Wr.flush();

                switch (input) {
                    case 1:
                        Adm_instr_red_user(W, R);
                        break;
                    case 2:
                        Adm_instr_red_Comp(W, R);
                        break;
                    case 3:
                        SHOW_DB(W, R);
                        break;
                    case 5:
                        Compare();
                        break;
                    case 6:
                        Adm_list(R, W);
                        break;
                    case 7:
                        Emegrency();
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        LoV = 0;
                        break;
                }
            }
            else {
                Wr.write("0" + "\n");
                Wr.flush();
                LoV = 0;
            }
        }
    }

    private static class User_menu extends Com_menu{
        BufferedReader Rd;
        BufferedWriter Wr;
        String login = "";
        int LoV = 2;
        int input = 0;

        void List_info_comp() throws IOException {
            SHOW_DB(Wr, Rd);
        }

        void List() throws IOException {
            list(Rd, Wr);
        }

        void Request_for_app_actvs(BufferedReader R, BufferedWriter W) throws IOException {
            New_Actvs NA = new New_Actvs(R, W);
            while(NA.isDisplayable()) {

            }
        }

        void Request_for_app_comp() throws IOException {
            Addition(Wr, Rd);
        }

        void Request_for_update_data() throws IOException {
            Redaction(Wr, Rd);
        }

        void Request_for_data_of_bankrots() throws IOException {
            Model_of_Bank MOB = new Model_of_Bank(Rd, "Model");
            while(MOB.isDisplayable()) {

            }
        }

        void Contract() throws IOException {
            Contract Cntr = new Contract(Rd, Wr);
            while(Cntr.isDisplayable()) {

            }
        }

        void Bankroting() throws IOException {
            Del_Bank(Wr, Rd, "B");
        }

        void Succes() throws IOException {
            Succes S = new Succes(Rd);
        }

        void AdvicesOnInvest() throws IOException {
            Model_of_Bank MOB = new Model_of_Bank(Rd, "Advice");
        }

        void Compare() throws IOException {
            Compare c = new Compare(Rd);
            while(c.isDisplayable()) {

            }
        }

        void SelfDestroy() throws IOException {
            SelfDestroy SD = new SelfDestroy(login, Wr);
            while(SD.isDisplayable()) {

            }
            String acc = Rd.readLine();
            if(acc.equals("yes"))
                LoV = 0;
        }

        void menu(BufferedWriter W, BufferedReader R, String L) throws IOException { // Main Func
            Wr = W;
            Rd = R;
            login = L;
            FX.User_menu Um = new FX.User_menu(login);
            while (Um.isDisplayable()) {

            }

            Wr.write(login + "\n");
            Wr.flush();
            String exist = Rd.readLine();

            if (exist.equals("exist")) {
                input = Um.input;
                Wr.write(Integer.toString(input) + "\n");
                Wr.flush();

                switch (input) {
                    case 1:
                        List_info_comp();
                        break;
                    case 2:
                        List();
                        break;
                    case 3:
                        Request_for_app_comp();
                        break;
                    case 4:
                        Request_for_update_data();
                        break;
                    case 5:
                        Request_for_data_of_bankrots();
                        break;
                    case 6:
                        Request_for_app_actvs(Rd, Wr);
                        break;
                    case 7:
                        Contract();
                        break;
                    case 8:
                        Bankroting();
                        break;
                    case 9:
                        SelfDestroy();
                        break;
                    case 10:
                        Succes();
                        break;
                    case 11:
                        AdvicesOnInvest();
                        break;
                    case 12:
                        Compare();
                        break;
                    default:
                        LoV = 0;
                        break;
                }
            }
            else {
                Wr.write("0" + "\n");
                Wr.flush();
                LoV = 0;
            }
        }

    }

    private static class Clt {

        private Socket sock;
        private BufferedReader reader;
        private BufferedWriter writer;
        private int Level_of_validation = 0;
        private boolean is_online = false;
        String login = "";

        Clt(Socket S) throws IOException {
            this.sock = S;
            this.reader = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(this.sock.getOutputStream()));
            this.is_online = true;
        }

        void Main_M() throws IOException {
            int Reg;
            Main_menu MM = new Main_menu();
            while(MM.isDisplayable()) {

            }
            Reg = MM.is_Reg;
            writer.write(Integer.toString(Reg) + "\n");
            writer.flush();

            if(Reg == 1)
                Registration();
            else
                if(Reg == 0)
                    Autorization();
                else {
                    Disconect();
                    is_online = false;
                }
        }

        void Autorization() throws IOException {
            FX.Autorization aut = new FX.Autorization(writer);
            while(aut.isDisplayable()) {

            }
            String[] param = reader.readLine().split(" ");
            login = param[1];
            Level_of_validation = Integer.parseInt(param[0]);
        }

        void Registration() throws IOException {
            Registration Reg = new Registration(writer);
            while(Reg.isDisplayable()) {

            }
        }

        void Start() throws IOException {

            while (is_online) {

                switch (Level_of_validation) {
                    case 1:
                        Admin_menu Adm_m = new Admin_menu();
                        Adm_m.menu(writer, reader, login);
                        Level_of_validation = Adm_m.LoV;
                        break;
                    case 2:
                        User_menu Usr_m = new User_menu();
                        Usr_m.menu(writer, reader, login);
                        Level_of_validation = Usr_m.LoV;
                        /*
                        Level_of_validation = Adm_m.LoV;*/
                        break;
                    case 0:
                        Main_M();
                        break;
                    default: break;
                }

            }
            Disconect();
        }

        void Disconect() throws IOException {
            this.sock.close();
        }
    }

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 7000);
        Clt CLIENT = new Clt(clientSocket);
        CLIENT.Start();

    }
}
